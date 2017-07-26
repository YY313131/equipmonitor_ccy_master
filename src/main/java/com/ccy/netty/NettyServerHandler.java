package com.ccy.netty;

import com.ccy.service.CollectedDataService;

import com.ccy.utils.CRCUtil;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Created by caihanbin on 2017/4/29.
 */
@Component
@ChannelHandler.Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

    @Autowired
    private CollectedDataService collectedDataService;

    /**
     * A thread-safe Set  Using ChannelGroup, you can categorize Channels into a meaningful group.
     * A closed Channel is automatically removed from the collection,
     */
    public static ChannelGroup channels =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {  // (2)
        Channel incoming = ctx.channel();
        // Broadcast a message to multiple Channels
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入\n");
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {  // (3)
        Channel incoming = ctx.channel();
        channels.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 离开\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object s) throws Exception { // (4)
        if(s instanceof CCYCollectedData) {
            CCYCollectedData collectedValue = (CCYCollectedData) s;
            if(collectedValue.errorMsg == null){
                if(collectedValue.sensorValues.size()==0){
                    responseSensorCollector(ctx, collectedValue);
                }else {
                    collectedDataService.add(collectedValue);
                    responseSensorCollector(ctx, collectedValue);
                }
            } else {
                System.out.println(collectedValue.errorMsg);
            }
            // TODO...
        }
    }

    private void responseSensorCollector(ChannelHandlerContext ctx, CCYCollectedData cd) {
        byte[] resp = new byte[17];
        resp[0] = 0x68;
        resp[1] = (byte)cd.areaNo.charAt(0);
        resp[2] = (byte)cd.areaNo.charAt(1);
        resp[3] = (byte)cd.areaNo.charAt(2);
        resp[4] = 0x30;
        resp[5] = (byte)((cd.collectorNo / 1000) + 0x30);
        resp[6] = (byte)(((cd.collectorNo % 1000) / 100) + 0x30);
        resp[7] = (byte)(((cd.collectorNo % 100) / 10) + 0x30);
        resp[8] = (byte)((cd.collectorNo % 10) + 0x30);
        resp[9] = 0x69;
        resp[10] = 0x02;
        resp[11] = (byte)(cd.cmd + 0x80);
        resp[12] = 0x00;
        resp[13] = 0x00;
        int crc = CRCUtil.getCRC16(resp, 0, 14);
        resp[14] = (byte)((crc & 0xFF00) >> 8);
        resp[15] = (byte)(crc & 0xFF);
        resp[16] = 0x0D;
        ctx.channel().writeAndFlush(Unpooled.wrappedBuffer(resp));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel incoming = ctx.channel();
        System.out.println("Client:"+incoming.remoteAddress()+"上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel incoming = ctx.channel();
        System.out.println("Client:"+incoming.remoteAddress()+"掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("Client:"+incoming.remoteAddress()+"异常");
        // 当出现异常就关闭连接
        //cause.printStackTrace();
        ctx.close();
    }
}
