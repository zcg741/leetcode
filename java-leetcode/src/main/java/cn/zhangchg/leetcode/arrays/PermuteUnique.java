package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @author 张晨刚
 */
public class PermuteUnique {

    public static void main(String[] args) {
        System.err.println(JSONArray.toJSONString(permuteUnique(new int[]{1, 1, 2})));
        System.err.println(JSONArray.toJSONString(permuteUnique(new int[]{1, 1, 1})));
        //System.err.println(JSONArray.toJSONString(permuteUnique(new int[]{1, 2, 1})));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
        }
        List<List<Integer>> listList = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            listList.add(list);
            return listList;
        }
        if (nums.length == 2) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            list.add(nums[1]);
            listList.add(list);
            if (nums[0] != nums[1]) {
                List<Integer> list2 = new ArrayList<>();
                list2.add(nums[1]);
                list2.add(nums[0]);
                listList.add(list2);
            }
            return listList;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                continue;
            }
            List<List<Integer>> permute = permute(nums, i);
            for (List<Integer> integers : permute) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(integers);
                listList.add(list);
            }
        }
        return listList;
    }

    private static List<List<Integer>> permute(int[] nums, int flag) {
        int[] ints = new int[nums.length - 1];
        for (int j = 0; j < nums.length; j++) {
            if (flag == j) {
                continue;
            }
            if (flag < j) {
                ints[j - 1] = nums[j];
            } else {
                ints[j] = nums[j];
            }

        }
        return permuteUnique(ints);
    }
}
