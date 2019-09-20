package cn.zhangchg.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * Related Topics 堆 Sliding Window
 *
 * @author zhangchg
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] flagArr = new int[nums.length + 1 - k];
        if (k == 0) {
            return flagArr;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int leftFlag = 0;
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        flagArr[leftFlag++] = getMaxNumByQueue(queue);
        for (int i = k; i < nums.length; i++) {
            queue.poll();
            queue.add(nums[i]);
            flagArr[leftFlag++] = getMaxNumByQueue(queue);
        }
        return flagArr;
    }

    private int getMaxNumByQueue(Queue<Integer> queue) {
        return queue.stream().max(Integer::compareTo).get();
    }
}
