package cn.zhangchg.leetcode.arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * @author 张晨刚
 */
public class JumpGame {

    public static void main(String[] args) {
        System.err.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.err.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.err.println(canJump(new int[]{0}));
        System.err.println(canJump(new int[]{1, 1, 1, 0}));
        System.err.println(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }

    public static boolean canJump(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > len) {
                return false;
            }
            len = (len > (nums[i] + i)) ? len : (nums[i] + i);
        }
        return true;
    }

    public static boolean canJump3(int[] nums) {
        int index = nums.length - 2, min = nums.length - 1;
        while (index >= 0) {
            if (index + nums[index] >= min) {
                min = index;
            }
            index--;
        }
        return min == 0;
    }
}
