package cn.zhangchg.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Foo {

    private boolean isFirst = false;
    private boolean isSecond = false;
    private final Object o = new Object();

    private CountDownLatch countDownLatchA = new CountDownLatch(1);
    private CountDownLatch countDownLatchB = new CountDownLatch(1);

    private Semaphore semaphoreFirst = new Semaphore(0);
    private Semaphore semaphoreSecont = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        //printFirst.run();
        //semaphoreFirst.release();

        printFirst.run();
        countDownLatchA.countDown();

        //synchronized (o) {
        //    printFirst.run();
        //    isFirst = true;
        //    o.notifyAll();
        //}
    }

    public void second(Runnable printSecond) throws InterruptedException {
        //semaphoreFirst.acquire();
        //printSecond.run();
        //semaphoreSecont.release();

        countDownLatchA.await();
        printSecond.run();
        countDownLatchB.countDown();
        //synchronized (o) {
        //    while (!isFirst){
        //        o.wait();
        //    }
        //    printSecond.run();
        //    isSecond = true;
        //    o.notifyAll();
        //}
    }

    public void third(Runnable printThird) throws InterruptedException {
        //semaphoreSecont.acquire();
        //printThird.run();

        countDownLatchB.await();
        printThird.run();

        //synchronized (o) {
        //    while (!isSecond){
        //        o.wait();
        //    }
        //    printThird.run();
        //}
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        new Thread(() -> {
            try {
                foo.second(() -> {
                    System.out.print("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.first(() -> {
                    System.out.print("one");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(() -> {
                    System.out.print("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
