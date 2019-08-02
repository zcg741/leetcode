package cn.zhangchg.leetcode.thread

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 * 我们提供一个类：
 *
 *
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 *
 *
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *  
 *
 *
 * 示例 1:
 *
 *
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 *
 *
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 *
 *
 */
class FooBar1(private val n: Int) {
    private val lock = ReentrantLock()
    private val one = lock.newCondition()
    private val two = lock.newCondition()
    @Volatile
    private var flag = 0
    private var obj = Object();
    private val mutex1 = AtomicInteger()
    private val mutex2 = AtomicInteger()

    init {
        mutex1.set(1)
        mutex2.set(0)
    }

    @Throws(InterruptedException::class)
    fun foo(printFoo: Runnable) {
/*        for (i in 0 until n) {
            lock.lock()
            if (flag != 0) {
                one.await()
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            flag = 1
            printFoo.run()
            //System.out.print("foo");
            two.signalAll()
            lock.unlock()

        }*/
/*
        for (i in 0 until n) {
            while (mutex1.get() <= 0);
            printFoo.run();
            mutex1.set(0);
            mutex2.set(1);
        }*/

        synchronized(obj) {
            for (i in 0 until n) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                if (flag != 0) {
                    obj.wait();
                }
                flag = 1;
                printFoo.run();
                obj.notifyAll();
            }
        }
    }

    @Throws(InterruptedException::class)
    fun bar(printBar: Runnable) {
/*        for (i in 0 until n) {
            lock.lock()
            if (flag != 1) {
                two.await()
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            flag = 0
            printBar.run()
            //System.out.print("bar");
            one.signalAll()
            lock.unlock()
        }*/
/*
        for (i in 0 until n) {
            while (mutex2.get() <= 0);
            printBar.run();
            mutex2.set(0);
            mutex1.set(1);
        }*/


         synchronized (obj) {
            for (i in 0 until n) {
                if (flag != 1) {
                    obj.wait();
                }
                flag = 0;
                //printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                obj.notifyAll();
            }
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val fooBar = FooBar1(3)
            Thread {
                try {
                    fooBar.bar(Thread { print("bar") })
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
            Thread {
                try {
                    fooBar.foo(Thread { print("foo") })
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
            //fooBar.bar();
            //new Thread(() -> {
            //}).start();
        }
    }
}
