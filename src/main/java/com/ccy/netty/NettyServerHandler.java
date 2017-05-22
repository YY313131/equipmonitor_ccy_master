package com.ccy.netty;

import com.ccy.service.CollectedDataService;
import com.ccy.service.Impl.CollectedDataServiceImpl;
import io.netty.channel.Channel;
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
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

    @Autowired
    private CollectedDataService collectedDataService;

    /**
     * A thread-safe Set  Using ChannelGroup, you can categorize Channels into a meaningful group.
     * A closed Channel is automatically removed from the collection,
     */
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

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
            System.out.println("**************************************");
            if(collectedValue.errorMsg == null){
                collectedDataService.add(collectedValue);
                // TODO...
            } else {
                System.out.println(collectedValue.errorMsg);
            }
            // TODO...
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { // (5)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception { // (6)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"掉线");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
