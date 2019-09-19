package cn.zhangchg.leetcode.thread;

import java.util.concurrent.*;

class H2O {

    private Semaphore s1,s2;

    public H2O() {
        s1 = new Semaphore(2); // H线程信号量
        s2 = new Semaphore(1); // O线程信号量

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        s1.acquire(); // 保证只有2个H线程进入执行
        releaseHydrogen.run();
        s2.release(); // 相当于唤醒1个H线程
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        s2.acquire(2); // 保证只有1个O线程进入执行
        releaseOxygen.run();
        s1.release(2); // 相当于唤醒1个O线程
    }


    public static void main(String[] args) {
        H2O h2O = new H2O();
        int n = 10;
        new Thread(() -> {
            try {
                for (int i = 0; i < n * 2; i++) {
                    h2O.hydrogen(new Thread(() -> {
                        System.out.print("H");
                    }));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    h2O.oxygen(new Thread(() -> {System.out.print("O");}));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
