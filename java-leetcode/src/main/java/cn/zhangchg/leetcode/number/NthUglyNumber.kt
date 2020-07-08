package cn.zhangchg.leetcode.number

import java.util.*

//编写一个程序，找出第 n 个丑数。
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
// Related Topics 堆 数学 动态规划
class NthUglyNumber {

    private val ugn = IntArray(1690)

    private fun genUgn() {
        if (ugn[ugn.size - 1] != 0) {
            return
        }
        ugn[0] = 1
        var i = 1
        var p2 = 1
        var p3 = 1
        var p5 = 1
        var x2 = 2
        var x3 = 3
        var x5 = 5
        while (i < ugn.size) {
            val next = min(x2, x3, x5)
            ugn[i] = next
            while (x2 <= next && p2 < ugn.size) {
                x2 = ugn[p2++] * 2
            }
            while (x3 <= next && p3 < ugn.size) {
                x3 = ugn[p3++] * 3
            }
            while (x5 <= next && p5 < ugn.size) {
                x5 = ugn[p5++] * 5
            }
            ++i
        }
    }

    fun nthUglyNumber1(n: Int): Int {
        genUgn()
        return ugn[n - 1]
    }

    fun nthUglyNumber(n: Int): Int {
        val list = ArrayList<Int>()
        list.add(1)
        var t2 = 0
        var t3 = 0
        var t5 = 0
        var curNum: Int
        for (i in 1 until n) {
            val i2 = list[t2] * 2
            val i3 = list[t3] * 3
            val i5 = list[t5] * 5
            curNum = min(i2, i3, i5)
            list.add(curNum)
            if (i2 == list[i]) {
                t2++
            }
            if (i3 == list[i]) {
                t3++
            }
            if (i5 == list[i]) {
                t5++
            }
        }
        return if (n == 0) 0 else list[n - 1]
    }

    fun min(a: Int, b: Int, c: Int): Int {
        val res = if (a > b) b else a
        return if (res > c) c else res
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val nthUglyNumber = NthUglyNumber()
            System.err.println(nthUglyNumber.nthUglyNumber(7))
            System.err.println(nthUglyNumber.nthUglyNumber(10))
//            System.err.println(nthUglyNumber.nthUglyNumber(1001))
        }
    }
}
