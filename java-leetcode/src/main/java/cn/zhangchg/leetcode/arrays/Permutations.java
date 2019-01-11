package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author 张晨刚
 */
public class Permutations {

    public static void main(String[] args) {
        System.err.println(JSONArray.toJSONString(permute(new int[]{4, 2, 3})));
    }

    private static List<List<Integer>> permute(int[] nums) {
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
            List<Integer> list2 = new ArrayList<>();
            list2.add(nums[1]);
            list2.add(nums[0]);
            listList.add(list2);
            return listList;
        }
        for (int i = 0; i < nums.length; i++) {
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
        return permute(ints);
    }
}
