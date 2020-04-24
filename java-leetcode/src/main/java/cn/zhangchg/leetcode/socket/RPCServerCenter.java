package cn.zhangchg.leetcode.socket;
/*
 * 文件名：PRCServerCenter.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved.
 * 描述： PRCServerCenter.java
 * 修改人：peiyu
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.zhangchg.leetcode.socket.RPCServer;

/**
 * @author peiyu
 */
public class RPCServerCenter implements RPCServer {
    private static Map<String, Class<?>> registerCenter = new HashMap<>();
    private ExecutorService executor = Executors.newCachedThreadPool();
    private boolean isRunnig = false;
    private int port = 80;

    public RPCServerCenter(int port) {
        this.port = port;
    }

    @Override
    public void stop() {
        try {
            executor.shutdown();
        } finally {
            isRunnig = false;
        }
    }

    @Override
    public void start() throws Throwable {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("server start at listen to " + port + "。。。。。。");
            isRunnig = true;
            while (true) {
                executor.execute(new RPCServiceHandler(serverSocket.accept(), registerCenter));
            }
        } finally {
            serverSocket.close();
        }
    }

    @Override
    public void register(Class<?> service, Class<?> serviceImpl) {
        registerCenter.put(service.getName(), serviceImpl);
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public boolean isRuning() {
        return this.isRunnig;
    }
}