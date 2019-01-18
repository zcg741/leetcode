package cn.zhangchg.leetcode.arrays;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，
 * TODO 尝试使用更为精妙的分治法求解。
 *
 * @author 张晨刚
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.err.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.err.println(maxSubArray(new int[]{-2, 0, -3, -5}));
        System.err.println(maxSubArray(new int[]{8, -19, 5, -4, 20}));
    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sub = max;
        for (int i = 1; i < nums.length; i++) {
            sub = sub + nums[i] > nums[i] ? sub + nums[i] : nums[i];
            max = max > sub ? max : sub;
        }
        return max;
    }
}
