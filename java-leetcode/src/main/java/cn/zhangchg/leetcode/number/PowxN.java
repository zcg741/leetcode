package cn.zhangchg.leetcode.number;

/**
 * Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * @author 张晨刚
 */
public class PowxN {
    public static void main(String[] args) {
        System.err.println(myPow(2.00000, 10));
        System.err.println(myPow(2.10000, 3));
        System.err.println(myPow(2.00000, -2));
        System.err.println(myPow(34.00515, -3));
    }

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isF = false;
        if (n < 0) {
            n = -n;
            isF = true;
        }
        double xSum = 1;
        for (; n >= 1; n >>= 1) {
            xSum *= n % 2 == 0 ? 1 : x;
            x *= x;
        }
        if (isF) {
            return 1 / xSum;
        }
        return xSum;
    }
}
