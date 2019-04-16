package cn.zhangchg.leetcode.number;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * 在函数里修改输入数组对于调用者是可见的。
 * 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * @author 张晨刚
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] ints = {1, 1, 2, 2};
        System.err.println(Arrays.toString(ints));
        System.err.println(removeDuplicates.removeDuplicates(ints));
        System.err.println(Arrays.toString(ints));
        ints = new int[]{1, 1, 1, 2, 2, 3};
        System.err.println(Arrays.toString(ints));
        System.err.println(removeDuplicates.removeDuplicates(ints));
        System.err.println(Arrays.toString(ints));
        ints = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.err.println(Arrays.toString(ints));
        System.err.println(removeDuplicates.removeDuplicates(ints));
        System.err.println(Arrays.toString(ints));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public int removeDuplicates3(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        if (nums[nums.length - 1] == nums[0]) {
            return 2;
        }
        int flag = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[0]) {
                if (nums[i + 1] == nums[0]) {
                    flag++;
                    continue;
                }
                nums[flag + 1] = nums[i + 1];
                nums[i + 1] = nums[0];
                continue;
            }
            if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != nums[i]) {
                        nums[flag] = nums[j];
                        nums[j] = nums[0];
                        break;
                    }
                    nums[j] = nums[0];
                }
            } else {
                nums[flag++] = nums[i];
            }
        }

        return flag + 1;
    }
}
