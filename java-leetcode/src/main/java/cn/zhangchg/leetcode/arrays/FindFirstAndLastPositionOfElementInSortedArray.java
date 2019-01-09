package cn.zhangchg.leetcode.arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author 张晨刚
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        //int[] nums = {5, 7, 7, 8, 8, 10};
        //int[] nums = {1,2,2,3,4,4,4};
        //int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10};
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 8, 8};
        //int[] nums = {2,2};
        //int[] nums = {7,8,1,2,3,4,5,6};
        //System.err.println(search(nums, 4));
        //System.err.println(search(nums, 3));
        int[] searchRange = searchRange(nums, 8);
        System.err.println(searchRange[0] + " , " + searchRange[1]);
    }

    /**
     * 搜索区间
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        if (nums[nums.length - 1] < target && nums[0] > target) {
            return new int[]{-1, -1};
        }
        int search = search(nums, 0, nums.length - 1, target, 0);
        if (search == -1) {
            return new int[]{-1, -1};
        }
        int searchLeft = search(nums, 0, search - 1, target, -1);
        int searchRight = search(nums, search + 1, nums.length - 1, target, 1);
        if (searchLeft == -1) {
            if (searchRight == -1) {
                return new int[]{search, search};
            } else {
                return new int[]{search, searchRight};
            }
        } else {
            if (searchRight == -1) {
                return new int[]{searchLeft, search};
            } else {
                return new int[]{searchLeft, searchRight};
            }
        }
    }


    public static int search(int[] nums, int begin, int end, int target, int flag) {
        if (end - begin < 0) {
            return -1;
        }
        if (end - begin == 1) {
            if (flag == 1) {
                if (target == nums[end]) {
                    return end;
                } else if (target == nums[begin]) {
                    return begin;
                } else {
                    return -1;
                }
            } else {
                if (target == nums[begin]) {
                    return begin;
                } else if (target == nums[end]) {
                    return end;
                } else {
                    return -1;
                }
            }
        }
        if (nums[end] < target || nums[begin] > target) {
            return -1;
        }
        if (begin == end && nums[begin] != target) {
            return -1;
        }
        int search;
        if (nums[(begin + end) / 2] == target) {
            search = (begin + end) / 2;
        } else {
            if (nums[(begin + end) / 2] > target) {
                search = search(nums, begin, (begin + end) / 2, target, 0);
                if (search == -1) {
                    return -1;
                }
                if (flag == 0) {
                    return search;
                }
            } else {
                search = search(nums, (begin + end) / 2, end, target, 0);
                if (search == -1) {
                    return -1;
                }
                if (flag == 0) {
                    return search;
                }
            }
        }
        if (flag == -1) {
            int searchLeft = search(nums, begin, search - 1, target, -1);
            if (searchLeft == -1) {
                return search;
            } else {
                return searchLeft;
            }
        }
        int searchRight = search(nums, search + 1, end, target, 1);
        if (searchRight == -1) {
            return search;
        } else {
            return searchRight;
        }
    }
}
