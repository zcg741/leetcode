package cn.zhangchg.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @author zhangchg
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        //System.err.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
        //System.err.println(majorityElement.majorityElement(new int[]{6, 5, 5}));
        System.err.println(majorityElement.majorityElement(new int[]{6, 6, 6, 7, 7}));
        //System.err.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2, 3}));
    }

    public int majorityElement(int[] nums) {
        int max = 1, maxFlag = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int flag = map.get(nums[i]) + 1;
                map.put(nums[i], flag);
                if ((max = Math.max(flag, max)) == flag) {
                    maxFlag = nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return maxFlag;
    }
}
