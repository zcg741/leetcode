package cn.zhangchg.leetcode.arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * @author 张晨刚
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2, 3, 4, 5,5,6,6,7,7,8,36,75}, new int[]{2, 3, 4, 2});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //把nums1设置为最短数组
        if (nums1.length > nums2.length) {
            int[] temps = nums1;
            nums1 = nums2;
            nums2 = temps;
        }
        int iMin = 0, iMax = nums1.length, halfLen = (nums1.length + nums2.length + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            // iMin 和 iMax 快接近了 并且数组2 前2位> 数组1
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                // i is too small
                iMin = i + 1;
            // iMin 和 iMax 快接近了 并且数组1 前1位 > 数组2
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                // i is too big
                iMax = i - 1;
            } else { // i is perfect
                int maxLeft;
                // 数组1 没有
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                // 数组2 没有
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    // 取得 最大的
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return maxLeft;
                }
                int minRight;
                //如果数组1 没有
                if (i == nums1.length) {
                    minRight = nums2[j];
                // 数组2 没有
                } else if (j == nums2.length) {
                    minRight = nums1[i];
                } else {
                    // 取得 最大的
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
