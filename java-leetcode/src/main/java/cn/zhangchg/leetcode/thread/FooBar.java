package cn.zhangchg.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我们提供一个类：
 * <p>
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 */
public class FooBar {
    private ReentrantLock lock = new ReentrantLock();
    private Condition one = lock.newCondition();
    private Condition two = lock.newCondition();
    private volatile int flag = 0;
    private int n;
    private volatile AtomicInteger mutex1 = new AtomicInteger();
    private volatile AtomicInteger mutex2 = new AtomicInteger();

    public FooBar(int n) {
        this.n = n;
        mutex1.set(1);
        mutex2.set(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (flag != 0) {
                one.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            flag = 1;
            printFoo.run();
            //System.out.print("foo");
            two.signalAll();
            lock.unlock();

        }

    /*    for (int i = 0;i < n; i++){
            while (mutex1.get() <= 0);
            printFoo.run();
            mutex1.set(0);
            mutex2.set(1);
        }
*/

/*        synchronized (this) {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (flag != 0) {
                    this.wait();
                }
                flag = 1;
                printFoo.run();
                this.notifyAll();
            }
        }*/
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            if (flag != 1) {
                two.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            flag = 0;
            printBar.run();
            //System.out.print("bar");
            one.signalAll();
            lock.unlock();
        }

      /*  for (int i = 0;i < n; i++){
            while (mutex2.get() <= 0);
            printBar.run();
            mutex2.set(0);
            mutex1.set(1);
        }*/


       /* synchronized (this) {
            for (int i = 0; i < n; i++) {
                if (flag != 1) {
                    this.wait();
                }
                flag = 0;
                //printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.notifyAll();
            }
        }*/
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        new Thread(() -> {
            try {
                fooBar.bar(new Thread(() -> System.out.print("bar")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(new Thread(() -> System.out.print("foo")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //fooBar.bar();
        //new Thread(() -> {
        //}).start();
    }
}
