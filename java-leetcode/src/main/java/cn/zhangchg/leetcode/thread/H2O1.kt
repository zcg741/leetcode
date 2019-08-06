package cn.zhangchg.leetcode.thread

import java.util.concurrent.Semaphore

internal class H2O1 {

    private val s1: Semaphore
    private val s2: Semaphore

    init {
        s1 = Semaphore(2) // H线程信号量
        s2 = Semaphore(1) // O线程信号量

    }

    @Throws(InterruptedException::class)
    fun hydrogen(releaseHydrogen: Runnable) {
        s1.acquire() // 保证只有2个H线程进入执行
        releaseHydrogen.run()
        s2.release() // 相当于唤醒1个H线程
    }

    @Throws(InterruptedException::class)
    fun oxygen(releaseOxygen: Runnable) {
        s2.acquire(2) // 保证只有1个O线程进入执行
        releaseOxygen.run()
        s1.release(2) // 相当于唤醒1个O线程
    }

    companion object {


        @JvmStatic
        fun main(args: Array<String>) {
            val h2O = H2O1()
            val n = 10
            Thread {
                try {
                    for (i in 0 until n * 2) {
                        h2O.hydrogen(Thread { print("H") })
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
            Thread {
                try {
                    for (i in 0 until n) {
                        h2O.oxygen(Thread { print("O") })
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }.start()
        }
    }
}
