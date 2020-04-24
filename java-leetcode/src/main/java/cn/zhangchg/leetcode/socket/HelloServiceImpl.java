package cn.zhangchg.leetcode.socket;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.err.println("hello " + name);
        return "hello " + name;
    }
}