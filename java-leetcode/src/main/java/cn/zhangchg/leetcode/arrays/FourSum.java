package cn.zhangchg.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author 张晨刚
 */
public class FourSum {

    public static void main(String[] args) {
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 2));
        //System.err.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        //System.err.println(fourSum(new int[]{5, 5, 3, 5, 1, -5, 1, -2}, 4));
        //System.err.println(fourSum(new int[]{0, 0, 0, 0}, 0));
        //System.err.println(fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1));
        //System.err.println(fourSum(new int[]{0, 1, 5, 0, 1, 5, 5, -4}, 11));
        System.err.println(fourSum(new int[]{-5, -4, -2, -2, -2, -1, 0, 0, 1}, -9));
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 2));
        //System.err.println(threeSumClosest(new int[]{1, 2, -2, -1}, 2));
        //System.err.println(threeSumClosest(new int[]{-1, 0, 1, 0}, 2));
        //System.err.println(threeSumClosest(new int[]{0, 0, 0}, 2));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && i < nums.length - 3 && nums[i] == nums[i - 1] && (nums[i] != 0 || nums[i - 1] == 0)) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 2; j--) {
                if (j != nums.length - 1 && j > i + 2 && nums[j] == nums[j + 1] && (nums[j] != 0 || nums[j + 1] == 0)) {
                    continue;
                }
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int temNum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temNum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        continue;
                    }
                    if (temNum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
            }
        }
        return list;
    }

}
