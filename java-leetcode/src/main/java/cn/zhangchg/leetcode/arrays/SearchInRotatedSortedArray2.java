package cn.zhangchg.leetcode.arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * <p>
 * 进阶:
 * <p>
 * <p>
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 *
 * @author 张晨刚
 */
public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        //System.err.println(search(nums, 4));
        System.err.println(search(nums, 3));
        //System.err.println(search(nums, 3));
        System.err.println(search(nums, 0));
    }

    public static boolean search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int index = -1;
        if (nums.length == 0)
            return false;
        if (target < nums[begin]) {
            while (end > 0) {
                if (nums[end] == target) {
                    index = end;
                    break;
                }

                end--;
            }
        }
        if (target > nums[begin]) {
            while (begin < nums.length) {
                if (nums[begin] == target) {
                    index = begin;
                    break;
                }

                begin++;
            }
        }
        if (target == nums[0]) {
            index = 0;
        }

        return index != -1;
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
        if (begin == end) {
            return -1;
        }
        if (end - begin == 1) {
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
