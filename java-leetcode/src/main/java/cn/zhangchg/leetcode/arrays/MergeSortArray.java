package cn.zhangchg.leetcode.arrays;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author 张晨刚
 */
public class MergeSortArray {
    public static void main(String[] args) {
        MergeSortArray mergeSortArray = new MergeSortArray();
        int[] ints = {0};
        System.err.println(Arrays.toString(ints));
        mergeSortArray.merge(ints, 0, new int[]{1}, 1);
        System.err.println(Arrays.toString(ints));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m + n) {
            return;
        }
        if (n == 0) {
            return;
        }
        if (m == 0) {
            n--;
            while (n >= 0) {
                nums1[n] = nums2[n];
                n--;
            }
            return;
        }
        int total = m + n - 1;
        int mMax = m - 1;
        int nMax = n - 1;
        while (mMax >= 0 && nMax >= 0) {
            if (nums1[mMax] > nums2[nMax]) {
                nums1[total--] = nums1[mMax--];
            } else {
                nums1[total--] = nums2[nMax--];
            }
        }
        if (mMax <= 0) {
            while (nMax >= 0) {
                nums1[total--] = nums2[nMax--];
            }
        }
    }
}
