package cn.zhangchg.leetcode.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],         2
 * [3,4],       5 ,6
 * [6,5,7],     11 10 13
 * [4,1,8,3]    15  11  18  16
 * ]
 * <p>
 * <p>
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 3, 1, 8));
        MinimumTotal minimumTotal = new MinimumTotal();
        System.err.println(minimumTotal.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> integerList1 = triangle.get(triangle.size() - 1);
        int dp[] = new int[integerList1.size()];
        for (int i = 0; i < integerList1.size(); i++) {
            dp[i] = integerList1.get(i);
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int min;
        List<Integer> listTmp = new ArrayList<>(triangle.get(0));
        for (int j = 1; j < triangle.size(); j++) {
            List<Integer> list = triangle.get(j);
            listTmp.add(list.get(0) + listTmp.get(0));
            for (int i = 1; i < list.size() - 1; i++) {
                listTmp.add(list.get(i) + Math.min(listTmp.get(i), listTmp.get(i - 1)));
            }
            listTmp.add(list.get(list.size() - 1) + listTmp.get(list.size() - 2));
            for (int i = 0; i < list.size() - 1; i++) {
                listTmp.remove(0);
            }
        }
        min = Integer.MAX_VALUE;
        for (Integer integerList : listTmp) {
            min = Math.min(integerList, min);
        }
        return min;
    }
}
