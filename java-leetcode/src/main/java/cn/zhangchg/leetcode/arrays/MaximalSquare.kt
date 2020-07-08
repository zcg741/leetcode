package cn.zhangchg.leetcode.arrays

import kotlin.math.max
import kotlin.math.min


//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
//
class MaximalSquare {

    fun maximalSquare(matrix: Array<CharArray>): Int {
        var maxSqlen = 0
        val len = matrix.size
        if (len == 0) {
            return maxSqlen * maxSqlen;
        }
        val ylen = matrix[0].size
        if (ylen == 0) {
            return maxSqlen * maxSqlen;
        }
        val dp = Array(len) { IntArray(ylen) }
        for (i in 0 until len) {
            for (j in 0 until ylen) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1
                    maxSqlen = 1
                }
            }
        }
        for (i in 1 until len) {
            for (j in 1 until ylen) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = min(min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1
                    maxSqlen = max(maxSqlen, dp[i][j])
                }
            }
        }
        return maxSqlen * maxSqlen
    }

    /**
     * 可怕，竟然没有人用kotlin写
     *
     */
    fun maximalSquare1(matrix: Array<CharArray>): Int {
        var maxSquare = 0
        val len = matrix.size
        if (len == 0) {
            return maxSquare;
        }
        val ylen = matrix[0].size
        if (ylen == 0) {
            return maxSquare;
        }
        for (i in 0 until len) {
            if ((len - i) * (len - i) <= maxSquare) {
                break;
            }
            for (j in 0 until ylen) {
                if ((ylen - j) * (ylen - j) <= maxSquare) {
                    break;
                }
                if (matrix[i][j] == '0') {
                    continue;
                }
                maxSquare = max(getMaxSquare(i, j, matrix), maxSquare);
            }
        }
        return maxSquare
    }

    private fun getMaxSquare(ii: Int, jj: Int, matrix: Array<CharArray>): Int {
        val len = matrix.size
        val ylen = matrix[0].size
        var minLen = ylen - jj
        var maxI = 0
        for (i in ii until len) {
            var minLenTmp = 0
            for (j in jj until ylen) {
                if (matrix[i][j] == '0') {
                    break;
                }
                minLenTmp++
            }
            if (minLenTmp < maxI) {
                minLen = min(minLen, maxI)
                break
            }
            minLen = min(minLen, minLenTmp)
            maxI++
        }
        minLen = min(minLen, maxI)
        return minLen * minLen
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val maximalSquare = MaximalSquare()
            val array = Array(5) { CharArray(2) }
            array[0] = charArrayOf('1', '0'/*, '1', '1', '1'*/)
            array[1] = charArrayOf('1', '0'/*, '1', '1', '1'*/)
            array[2] = charArrayOf('1', '1'/*, '1', '1', '1'*/)
            array[3] = charArrayOf('1', '1'/*, '1', '0', '1'*/)
            array[4] = charArrayOf('1', '0'/*, '1', '0', '1'*/)
            println(maximalSquare.maximalSquare(array))
        }
    }
}