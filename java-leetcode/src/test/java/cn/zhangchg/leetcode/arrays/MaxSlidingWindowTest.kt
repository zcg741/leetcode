package cn.zhangchg.leetcode.arrays

import org.junit.Test

import java.util.Arrays

class MaxSlidingWindowTest {

    @Test
    fun maxSlidingWindow() {
        val maxSlidingWindow = MaxSlidingWindow()
        System.err.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)))
    }
}