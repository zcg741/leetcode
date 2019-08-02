package cn.zhangchg.leetcode.thread

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import java.util.function.IntConsumer

/**
 * 假设有这么一个类：
 *
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 *
 *
 *  
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 *
 *
 * 输入：n = 5
 * 输出："0102030405"
 *
 *
 *
 * @author zhangchg
 */
class ZeroEvenOdd1(private val n: Int) {

    private val lock = ReentrantLock()
    private val zero = lock.newCondition()
    private val even = lock.newCondition()
    private val odd = lock.newCondition()
    private var flag = 0

    // printNumber.accept(x) outputs "x", where x is an integer.
    @Throws(InterruptedException::class)
    fun zero(printNumber: IntConsumer) {
        for (i in 0 until n) {
            lock.lock()
            if (flag != 0) {
                zero.await()
            }
            printNumber.accept(0)
            flag = if (i % 2 == 0) 1 else 2
            if (flag == 1) {
                odd.signalAll()
            } else {
                even.signalAll()
            }
            lock.unlock()
        }
    }

    @Throws(InterruptedException::class)
    fun even(printNumber: IntConsumer) {
        var i = 2
        while (i <= n) {
            lock.lock()
            if (flag != 2) {
                even.await()
            }
            printNumber.accept(i)
            flag = 0
            zero.signalAll()
            lock.unlock()
            i += 2
        }
    }

    @Throws(InterruptedException::class)
    fun odd(printNumber: IntConsumer) {
        var i = 1
        while (i <= n) {
            lock.lock()
            if (flag != 1) {
                odd.await()
            }
            printNumber.accept(i)
            flag = 0
            zero.signalAll()
            lock.unlock()
            i += 2
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val zeroEvenOdd = ZeroEvenOdd1(5)
            Thread {
                try {
                    zeroEvenOdd.zero(IntConsumer { print(it) })
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
            Thread {
                try {
                    zeroEvenOdd.even(IntConsumer { print(it) })
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
            Thread {
                try {
                    zeroEvenOdd.odd(IntConsumer { print(it) })
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }
}
