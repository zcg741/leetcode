package cn.zhangchg.leetcode.thread

import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread


class Foo1 {
    private var countDownLatchA: CountDownLatch? = null
    private var countDownLatchB: CountDownLatch? = null

    init {
        countDownLatchA = CountDownLatch(1)
        countDownLatchB = CountDownLatch(1)
    }

    fun one() {
        print("one")
        countDownLatchA?.countDown()
    }

    fun two() {
        countDownLatchA?.await()
        print("two")
        countDownLatchB?.countDown()
    }

    fun three() {
        countDownLatchB?.await()
        print("three")
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var foo = Foo1();
            object : Thread() {
                override fun run() {
                    foo.two()
                }
            }.start()
            thread(start = true) {
                //                TimeUnit.SECONDS.sleep(10);
                foo.one()
            }
            Thread {
                foo.three()
            }.start()
        }
    }
}
