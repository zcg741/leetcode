package cn.zhangchg.leetcode.number;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * @author 张晨刚
 */
public class PermutationSequence {

    public static void main(String[] args) {
        System.err.println(getPermutation(3, 3));
        System.err.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> arrs = new LinkedList<>();
        int[] sumArrs = new int[n + 1];
        sumArrs[0] = 1;
        for (int i = 0; i < n; i++) {
            arrs.add(i + 1);
            sumArrs[i + 1] = sumArrs[i] * (i + 1);
        }
        StringBuffer sb = new StringBuffer();
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / sumArrs[i];
            sb.append(arrs.remove(index));
            k -= index * sumArrs[i];
        }
        return sb.toString();
    }
}
