package cn.zhangchg.leetcode.number;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * @author 张晨刚
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        //System.err.println(divide(10, 3));
        //System.err.println(divide(7, -3));
        //System.err.println(divide(-7, -3));
        System.err.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor) {
        ///处理异常
        if (divisor == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        //处理最大最小值取模的情况。
        long divid = (long) dividend;
        long divi = (long) divisor;
        //减少重复运算
        if (divi == 1) {
            return (int) divid;
        }
        if (divi == -1) {
            //处理溢出
            if (divid <= min) {
                return max;
            }
            return (int) -divid;
        }
        boolean flag = true;
        //处理符号
        if (divid < 0) {
            divid = -divid;
            if (divi < 0) {
                divi = -divi;
            } else {
                flag = false;
            }
        } else if (divi < 0) {
            divi = -divi;
            flag = false;
        }
        long res = 0;
        long tmp = 0;
        long cnt = 1;
        while (divi <= divid) {
            //2^n次方
            cnt = 1;
            tmp = divi;
            //找到第一个大于被除数的2^n次方
            while (tmp <= divid) {
                tmp <<= 1;
                cnt <<= 1;
            }
            res += (cnt >> 1);
            //减去基数的前一个数
            divid -= (tmp >> 1);
        }

        return flag ? (int) res : (int) -res;
    }

}
