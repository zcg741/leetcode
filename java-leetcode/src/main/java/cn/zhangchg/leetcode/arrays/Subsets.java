package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author 张晨刚
 */
public class Subsets {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> combine;
        combine = subsets(new int[]{1, 2, 3});
        long end = System.currentTimeMillis();
        System.err.println(end - start);
        System.err.println(JSONArray.toJSONString(combine));
        System.err.println(combine.size());
        //start = System.currentTimeMillis();
        //combine = subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        //end = System.currentTimeMillis();
        //System.err.println(end - start);
        //System.err.println(JSONArray.toJSONString(combine));
        //System.err.println(combine.size());
        // 4845
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists1 = new LinkedList<>(lists);
            for (List<Integer> integers : lists1) {
                List<Integer> newList = new LinkedList<>();
                newList.addAll(integers);
                newList.add(nums[i]);
                lists.add(newList);
            }
            List<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            lists.add(list);
        }
        lists.add(Collections.emptyList());
        return lists;
    }

    /**
     * 递归超时
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        if (nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> lists = new LinkedList<>();
        return getCombine(lists, nums, nums.length);
    }

    /**
     * @param list
     * @param li
     * @param n
     * @param k
     */
    public static void huishu(List<List<Integer>> list, List<Integer> li, int n, int k) {
        if (k == 0) {
            list.add(li);
            return;
        }
        if (n < k) {
            list.add(li);
            return;
        }
        list.add(li);
        for (int i = n; i >= 1; i--) {
            List<Integer> copy = new LinkedList<>();
            copy.addAll(li);
            copy.add(i);
            huishu(list, copy, i - 1, k - 1);
        }
    }

    /**
     * @param lists
     * @param nums
     * @param k
     * @return
     */
    public static List<List<Integer>> getCombine(List<List<Integer>> lists, int[] nums, int k) {
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                lists.add(list);
            }
            return lists;
        }
        if (nums.length == k) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            return getCombine(lists, nums, k - 1);
        }
        List<List<Integer>> combine = getCombine(lists, nums, k - 1);
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            for (int i1 = 0; i1 < combine.size(); i1++) {
                List<Integer> list = combine.get(i1);
                if (list.contains(b)) {
                    continue;
                }
                if (list.get(0) > b) {
                    continue;
                }
                if (list.get(list.size() - 1) > b) {
                    continue;
                }
                List arrayList = new LinkedList(list);
                arrayList.add(b);
                lists.add(arrayList);
            }
        }
        return lists;
    }

}
