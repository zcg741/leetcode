package cn.zhangchg.leetcode.arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author 张晨刚
 */
public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 7, 7, 8, 8, 8, 8};
        int search = searchInsert(nums, 6);
        System.err.println(search);
        nums = new int[]{1, 3, 5, 6};
        search = searchInsert(nums, 5);
        System.err.println(search);
        nums = new int[]{1, 3, 5, 6};
        search = searchInsert(nums, 2);
        System.err.println(search);
        nums = new int[]{1, 3, 5, 6};
        search = searchInsert(nums, 7);
        System.err.println(search);
        nums = new int[]{1, 3, 5, 6};
        search = searchInsert(nums, 0);
        System.err.println(search);
    }

    public static int searchInsert(int[] nums, int target) {
        int search = search(nums, 0, nums.length - 1, target);
        return search;
    }

    public static int search(int[] nums, int begin, int end, int target) {
        if (end - begin < 0) {
            return -1;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        if (nums[begin] > target) {
            return begin;
        }
        if (end - begin == 1) {
            if (target == nums[begin]) {
                return begin;
            } else if (target == nums[end]) {
                return end;
            } else {
                return end;
            }
        }
        if (begin == end && nums[begin] != target) {
            return -1;
        }
        int search;
        if (nums[(begin + end) / 2] == target) {
            return (begin + end) / 2;
        }
        if (nums[(begin + end) / 2] > target) {
            search = search(nums, begin, (begin + end) / 2, target);
            if (search == -1) {
                return -1;
            }
            return search;
        } else {
            search = search(nums, (begin + end) / 2, end, target);
            if (search == -1) {
                return -1;
            }
            return search;
        }

    }
}
