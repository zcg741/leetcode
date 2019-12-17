package cn.zhangchg.leetcode.number;

/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 16
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: false
 * <p>
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * Related Topics 位运算
 */

public class IsPowerOfFour {

    public boolean isPowerOfFour(int num) {
        return ((num & 0x55555555) != 0) && ((num & (num - 1)) == 0);
    }

    public static void main(String[] args) {
        IsPowerOfFour isPowerOfFour = new IsPowerOfFour();
        System.err.println(isPowerOfFour.isPowerOfFour(-4));
        System.err.println(isPowerOfFour.isPowerOfFour(5));
        System.err.println(isPowerOfFour.isPowerOfFour(16));
    }
}
