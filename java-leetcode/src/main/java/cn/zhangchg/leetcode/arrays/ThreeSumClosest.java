package cn.zhangchg.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author 张晨刚
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 2));
        System.err.println(threeSumClosestMan(new int[]{-1, 2, 1, -4}, 1));
        System.err.println(threeSumClosestMan(new int[]{1, 1, 1, 0}, -1000));
        System.err.println(threeSumClosestMan(new int[]{0, 2, 1, -3}, 1));
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 2));
        //System.err.println(threeSumClosest(new int[]{1, 2, -2, -1}, 2));
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 0}, 2));
        //System.err.println(threeSumClosest(new int[]{0, 0, 0}, 2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int maxNum = Integer.MAX_VALUE;
        int sumFlag = target;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temNum = nums[i] + nums[left] + nums[right];
                if(target == temNum){
                    return target;
                }
                int abs = Math.abs(target - temNum);
                if (maxNum >abs ) {
                    sumFlag = temNum;
                    maxNum = abs;
                }
                if (temNum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return sumFlag;
    }

    public static int threeSumClosestMan(int[] nums, int target) {
        if (nums.length < 3) {
            return target;
        }
        int maxNum = Integer.MAX_VALUE;
        int sumFlag = target;
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (maxNum > Math.abs(target - nums[i] - nums[j] - nums[k])) {
                        sumFlag = nums[i] + nums[j] + nums[k];
                        maxNum = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    }
                }
            }
        }
        return sumFlag;
    }
}
