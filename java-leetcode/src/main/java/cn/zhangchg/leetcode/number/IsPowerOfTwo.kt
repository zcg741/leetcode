package cn.zhangchg.leetcode.number

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 *
 * 示例 1:
 *
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 *
 *
 * 示例 2:
 *
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 *
 *
 * 示例 3:
 *
 *
 * 输入: 218
 * 输出: false
 * Related Topics 位运算 数学
 */
class IsPowerOfTwo {

    fun isPowerOfTwo2(n: Int): Boolean {
        var flag = 1
        while (n > flag) {
            flag *= 2
            if (flag < 0) {
                return false
            }
        }
        return n == flag
    }

    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && n and (n - 1) == 0
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val isPowerOfTwo = IsPowerOfTwo()
            System.err.println(isPowerOfTwo.isPowerOfTwo(1073741825))
            System.err.println(isPowerOfTwo.isPowerOfTwo(16))
            System.err.println(isPowerOfTwo.isPowerOfTwo(1))
            System.err.println(isPowerOfTwo.isPowerOfTwo(-1))
            System.err.println(isPowerOfTwo.isPowerOfTwo(218))
        }
    }
}
