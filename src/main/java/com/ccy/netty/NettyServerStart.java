package com.ccy.netty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/22.
 */
@Service
public class NettyServerStart {

    @Autowired
    public NettyServerStart(final NettyServer nettyServer) {
        System.out.println("------------Spring自动加载 ---------");
        System.out.println("------------启动Netty服务 ---------");
        nettyServer.setServerPort(7095);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(nettyServer);
    }
}
