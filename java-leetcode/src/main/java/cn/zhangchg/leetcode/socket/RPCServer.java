package cn.zhangchg.leetcode.socket;

/*
 * 文件名：PRCServer.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved.
 * 描述： PRCServer.java
 * 修改人：peiyu
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */

/**
 * @author peiyu
 */
public interface RPCServer {
    public void stop();

    public void start() throws Throwable;

    public void register(Class<?> service, Class<?> serviceImpl);

    public int getPort();

    public boolean isRuning();
}