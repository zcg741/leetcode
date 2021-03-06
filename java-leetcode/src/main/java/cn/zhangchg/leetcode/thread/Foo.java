package cn.zhangchg.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * 我们提供了一个类：
 * <p>
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * 示例 2:
 * <p>
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 *  
 * <p>
 * 注意:
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * <p>
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 */
public class Foo {

    private boolean isFirst = false;
    private boolean isSecond = false;
    private final Object o = new Object();

    private CountDownLatch countDownLatchA = new CountDownLatch(1);
    private CountDownLatch countDownLatchB = new CountDownLatch(1);

    private Semaphore semaphoreFirst = new Semaphore(0);
    private Semaphore semaphoreSecond = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphoreFirst.release();

        //printFirst.run();
        //countDownLatchA.countDown();

        //synchronized (o) {
        //    printFirst.run();
        //    isFirst = true;
        //    o.notifyAll();
        //}
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphoreFirst.acquire();
        printSecond.run();
        semaphoreSecond.release();

        //countDownLatchA.await();
        //printSecond.run();
        //countDownLatchB.countDown();

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
        semaphoreSecond.acquire();
        printThird.run();

        //countDownLatchB.await();
        //printThird.run();

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
