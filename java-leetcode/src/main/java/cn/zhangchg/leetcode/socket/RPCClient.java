package cn.zhangchg.leetcode.socket;
/*
 * 文件名：PRCClient.java
 * 版权：Copyright 2007-2017 517na Tech. Co. Ltd. All Rights Reserved.
 * 描述： PRCClient.java
 * 修改人：peiyu
 * 修改时间：2017年3月17日
 * 修改内容：新增
 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.alibaba.fastjson.JSON;

/**
 * @author peiyu
 */
public class RPCClient<T> {
    @SuppressWarnings("unchecked")
    public static <T> T getPRCProxy(Class<T> clazz, final InetSocketAddress addr) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectInputStream ois = null;
                ObjectOutputStream oos = null;
                try {
                    socket = new Socket();
                    socket.connect(addr);
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    InvokeModel invokeModel = getInvokeModel(clazz, method, args);
                    oos.writeUTF(JSON.toJSONString(invokeModel));
                    oos.flush();
                    ois = new ObjectInputStream(socket.getInputStream());
                    return ois.readUTF();
                } finally {
                    socket.close();
                    oos.close();
                    ois.close();
                }
            }
        });
    }
    private static <T> InvokeModel getInvokeModel(Class<T> clazz, Method method, Object[] args) {
        InvokeModel invokeModel = new InvokeModel();
        invokeModel.setMethodName(method.getName());
        invokeModel.setParams(args);
        invokeModel.setServiceName(clazz.getName());
        invokeModel.setParamsType(method.getParameterTypes());
        return invokeModel;
    }
}
