package cn.zhangchg.leetcode.number;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 * @author 张晨刚
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.err.println(reverse(2147483647));
        System.err.println(reverse(101));
        System.err.println(reverse(004));
        System.err.println(reverse(-4232));
        System.err.println(reverse(232));
    }

    public static int reverse(int x) {
        if(1 << 31 == x){
            return 0;
        }
        int maxX = (1 << 31) - 1;
        if (x < 0) {
            return 0 - reverse(0 - x);
        }
        int y = 0;
        while (x > 0) {
            if(y > maxX  / 10){
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}
