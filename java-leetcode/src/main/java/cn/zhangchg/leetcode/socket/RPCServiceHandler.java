package cn.zhangchg.leetcode.socket;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @author peiyu
 */
public class RPCServiceHandler implements Runnable {
    private Socket client;
    private Map<String, Class<?>> registerCenter;
    public RPCServiceHandler(Socket client, Map<String, Class<?>> registerCenter) {
        this.client = client;
        this.registerCenter = registerCenter;
    }
    @Override
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            //将客户端发送的码流反序列化成对象，反射调用服务实现者，获取执行结果
            input = new ObjectInputStream(client.getInputStream());
            String param =input.readUTF();
            System.out.println("请求参数：" + param);
            InvokeModel invokeModel = JSON.parseObject(param, InvokeModel.class);
            Class<?> serviceClass = registerCenter.get(invokeModel.getServiceName());
            if (serviceClass == null) {
                throw new ClassNotFoundException(invokeModel.getServiceName() + " not found");
            }
            Method method = serviceClass.getMethod(invokeModel.getMethodName(), invokeModel.getParamsType());
            Object result = method.invoke(serviceClass.newInstance(), invokeModel.getParams());
            System.out.println("返回结果：" + JSON.toJSONString(result));
            //将执行结果反序列化，通过socket发送给客户端
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeUTF(JSON.toJSONString(result));
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}