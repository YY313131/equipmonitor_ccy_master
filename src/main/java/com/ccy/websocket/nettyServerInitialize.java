package com.ccy.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by caihanbin on 2017/4/29.
 */
public class nettyServerInitialize extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //pipeline.addLast("decoder", new LengthFieldBasedFrameDecoder(8192,12,2,0,0));
        pipeline.addLast("decoder", new CCYLengthFieldDecoder(8192,12,2,0,0));
        pipeline.addLast("handler", new nettyServerHandler());
        System.out.println("SimpleChatClient:"+ch.remoteAddress() +"连接上");
    }
}
