package cn.zhangchg.leetcode.socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetSocketAddress;

public class Consumer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress addr = new InetSocketAddress("localhost", 8888);
        HelloService helloService = RPCClient.getPRCProxy(HelloService.class, addr);
        System.out.println("prc返回：" + helloService.sayHello("张三"));
    }
}

