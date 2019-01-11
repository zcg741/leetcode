package cn.zhangchg.leetcode.number;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * @author 张晨刚
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        System.err.println(firstMissingPositive(new int[]{1, 2, 3}));
        System.err.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.err.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.err.println(firstMissingPositive(new int[]{1}));
        System.err.println(firstMissingPositive(new int[]{1, 1000}));
        System.err.println(firstMissingPositive(new int[]{124141247, 1241412478, 1241412479, 124141211, 124141712}));
    }

    private static int firstMissingPositive(int[] nums) {
        int minFlag = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            minFlag = Math.min(minFlag, num);
        }
        if (minFlag != 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            nums[i] -= minFlag;
        }
        int maxFlag = 1;
        maxFlag += IntStream.range(0, nums.length).filter(i -> nums[i] > 0).count();
        int[] temInt = new int[maxFlag];
        for (int num : nums) {
            if (num <= 0 || num >= maxFlag) {
                continue;
            }
            temInt[num] = 1;
        }
        for (int i = 1; i < temInt.length; i++) {
            if (temInt[i] == 0) {
                return minFlag + i;
            }
        }
        return temInt.length + 1;
    }

    /**
     * 使用hashMap
     *
     * @param nums 数组
     * @return 第一个正数
     */
    public static int firstMissingPositive2(int[] nums) {
        int minFlag = 1, maxFlag = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num == minFlag) {
                minFlag++;
            }
            map.put("" + num, 1);
        }
        for (int i = minFlag; i < maxFlag; i++) {
            if (!map.containsKey("" + i)) {
                return i;
            }
        }
        return 1;
    }
}
