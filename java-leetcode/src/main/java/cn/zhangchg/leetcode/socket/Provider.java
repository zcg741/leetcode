package cn.zhangchg.leetcode.socket;

public class Provider {
    public static void main(String[] args) throws Exception {
        RPCServer prcServer=new RPCServerCenter(8888);
        prcServer.register(HelloService.class, HelloServiceImpl.class);
        try {
            prcServer.start();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}