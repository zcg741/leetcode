package cn.zhangchg.leetcode.number;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author 张晨刚
 */
public class Combinations {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<List<Integer>> combine;
        //combine(4, 2);
        long end = System.currentTimeMillis();
        //System.err.println(end - start);
        //System.err.println(JSONArray.toJSONString(combine));
        //System.err.println(combine.size());
        //start = System.currentTimeMillis();
        combine = combine(3, 2);
        end = System.currentTimeMillis();
        System.err.println(end - start);
        System.err.println(JSONArray.toJSONString(combine));
        System.err.println(combine.size());
        //4845
    }

    public static List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return Collections.EMPTY_LIST;
        }
        return getCombine(n, k, k);
    }

    /**
     * 递归超时
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine2(int n, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> combine = getCombine(n, k, k);
        return combine;
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
            return;
        }
        for (int i = n; i >= 1; i--) {
            List<Integer> copy = new LinkedList<>();
            copy.addAll(li);
            copy.add(i);
            huishu(list, copy, i - 1, k - 1);
        }
    }

    /**
     * @param n
     * @param k
     * @param oldK
     * @return
     */
    public static List<List<Integer>> getCombine(int n, int k, int oldK) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        if (k == 1) {
            for (int i = k; i <= n; i++) {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                lists.add(list);
            }
            return lists;
        }
        if (n == k) {
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            lists.add(list);
            return lists;
        }
        List<List<Integer>> combine = getCombine(n - 1, k - 1, k);
        for (int i = 1; i <= n; i++) {
            int b = i;
            combine.forEach(list -> {
                if (list.contains(b)) {
                    return;
                }
                if (list.get(0) > b) {
                    return;
                }
                if (list.get(list.size() - 1) > b) {
                    return;
                }
                List arrayList = new LinkedList(list);
                arrayList.add(b);
                lists.add(arrayList);
            });
        }
        return lists;
    }

}
