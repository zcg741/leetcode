package cn.zhangchg.leetcode.arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * @author 张晨刚
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {7,8,1,2,3,4,5,6};
        //System.err.println(search(nums, 4));
        //System.err.println(search(nums, 3));
        System.err.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if (nums[nums.length - 1] < target && nums[0] > target) {
            return -1;
        }
        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        if(0 == nums.length - 1){
            return -1;
        }
        if(nums.length == 2){
            return -1;
        }
        if (nums[nums.length - 1] > target) {
            int searchRight = search(nums, nums.length / 2, nums.length - 1, target);
            if (searchRight != -1) {
                return searchRight;
            } else {
                int searchLeft = search(nums, 0, nums.length / 2, target);
                return searchLeft;
            }
        }

        if (nums[0] < target) {
            int searchLeft = search(nums, 0, nums.length / 2, target);
            if (searchLeft != -1) {
                return searchLeft;
            } else {
                int searchRight = search(nums, nums.length / 2, nums.length - 1, target);
                return searchRight;
            }
        }
        return -1;
    }


    public static int search(int[] nums, int begin, int end, int target) {
        if (nums[end] < target && nums[begin] > target) {
            return -1;
        }
        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }
        if(begin == end){
            return -1;
        }
        if(end - begin == 1){
            return -1;
        }
        if (nums[end] > target) {
            int searchRight = search(nums, (begin + end) / 2, end, target);
            if (searchRight != -1) {
                return searchRight;
            } else {
                int searchLeft = search(nums, begin, (begin + end) / 2, target);
                return searchLeft;
            }
        }

        if (nums[begin] < target) {
            int searchLeft = search(nums, begin, (begin + end) / 2, target);
            if (searchLeft != -1) {
                return searchLeft;
            } else {
                int searchRight = search(nums, (begin + end) / 2, end, target);
                return searchRight;
            }
        }
        return -1;
    }
}
