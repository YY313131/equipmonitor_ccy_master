package com.ccy.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by caihanbin on 2017/4/29.
 */
@Component
public class NettyServerInitialize extends ChannelInitializer<SocketChannel> {

    @Autowired
    private NettyServerHandler nettyServerHandler;

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //pipeline.addLast("decoder", new LengthFieldBasedFrameDecoder(8192,12,2,0,0));
        pipeline.addLast("decoder", new CCYLengthFieldDecoder(8192,12,2,0,0));
        pipeline.addLast("handler", nettyServerHandler);
        System.out.println("SimpleChatClient:"+ch.remoteAddress() +"连接上");
    }
}
