package cn.zhangchg.leetcode.string

import kotlin.math.max

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
class LongestPalindrome {

    fun longestPalindrome(s: String): String {
        val n = s.length
        if (n == 0 || n == 1) {
            return s
        }

        var left = 0
        var right =0
        for (i in 0 until n) {
            val len1 = getLongestLen(s,i,i)
            val len2 = getLongestLen(s,i,i+1)
            val len = max(len1, len2)
            if (len > right-left) {
                left = i - (len-1)/2//-1是为了防止出现小于0
                right = i+len/2
            }
        }
        return s.subSequence(left,right+1).toString()
    }

    private fun getLongestLen(s: String, left:Int, right:Int):Int{
        var lef = left
        var righ = right
        while (lef >= 0 && righ < s.length && s[lef] == s[righ]) {
            lef--
            righ++
        }
        return righ - lef+1-2
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val longestPalindrome = LongestPalindrome()
            println(longestPalindrome.longestPalindrome("aabb"))
            println(longestPalindrome.longestPalindrome("ababb"))
            println(longestPalindrome.longestPalindrome("ababab"))
        }
    }
}
