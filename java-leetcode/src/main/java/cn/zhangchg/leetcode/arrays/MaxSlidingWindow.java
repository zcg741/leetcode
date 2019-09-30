package cn.zhangchg.leetcode.arrays;

import javafx.collections.transformation.SortedList;

import java.util.TreeSet;

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
        int size = k;
        if (size == 0 || size > nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length - size + 1];
        int index = -1, max = 0;
        //i表示的是窗的起始索引，所以最大只能是num.length - size
        for (int i = 0; i <= nums.length - size; i++) {
            //最大值的索引小于当前窗的起始索引，说明这个最大值已经过期
            if (index < i) {
                //保证最大值是在新的窗中
                max = nums[i];
                for (int j = i + 1; j < i + size; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        index = j;
                    }
                }
                //最大值未过期，判断当前窗的最后一个元素是否比Max大（因为此时的最大值是从上一个窗中选出的，其余元素已经进行了比较，只有新增的这个元素，即当前窗的最后一个元素未进行比较）。
            } else {
                if (nums[i + size - 1] >= max) {
                    index = i + size - 1;
                    max = nums[i + size - 1];
                }
            }
            result[i] = max;
        }
        return result;
    }

}
