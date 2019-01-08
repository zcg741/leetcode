package cn.zhangchg.leetcode.arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author 张晨刚
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] ints = {2, 3, 1};
        nextPermutation(ints);
        for (int i : ints) {
            System.err.print(i + " ");
        }
        System.err.println(" ");
        //ints = new int[]{5, 4, 7, 5, 3, 2};
        //nextPermutation(ints);
        //for (int i : ints) {
        //    System.err.print(i + " ");
        //}
        //System.err.println(" ");
        //[5,5,2,3,4,7]
        //ints = new int[]{3, 2, 1};
        //nextPermutation(ints);
        //for (int i : ints) {
        //    System.err.print(i + " ");
        //}
        //System.err.println(" ");
        //ints = new int[]{1, 1, 5};
        //nextPermutation(ints);
        //for (int i : ints) {
        //    System.err.print(i + " ");
        //}
    }

    public static void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {//到头了，则恢复最小值
                reverse(nums, 0);
                return;
            }
            if (nums[i] > nums[i - 1]) {//1.从右往左首先找到最后一个正序，就是nums[i-1]<nums[i]，我们称它为L
                break;
            }
        }
        int L = i - 1;
        for (j = nums.length - 1; j > L; j--) {//2.从右往左，找到第一个大于nums[i-1]的数字，称它为R
            if (nums[j] > nums[L]) {
                break;
            }
        }
        int R = j;
        int tmp = nums[L];
        nums[L] = nums[R];
        nums[R] = tmp;//3.交换L,R
        reverse(nums, L + 1);//4.反转L后面的元素
        return;
    }

    public static void reverse(int[] nums, int start) {
        //从第start位开始，进行反转
        int sum = start + nums.length;
        int mid = sum / 2;
        for (; start < mid; start++) {
            int tt = nums[start];
            nums[start] = nums[sum - 1 - start];
            nums[sum - 1 - start] = tt;
        }
        return;
    }
}
