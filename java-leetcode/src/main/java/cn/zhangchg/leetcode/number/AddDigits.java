package cn.zhangchg.leetcode.number;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * <p>
 * <p>
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * Related Topics 数学
 *
 * @author zhangchg
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        //System.err.println(addDigits.addDigits(38));
        //System.err.println(addDigits.addDigits(11345));
        System.err.println(addDigits.addDigits(1132345));
        System.err.println(addDigits.addDigits(1132423345));
    }

    public int addDigits(int num) {
        int i = 0;
        while (num >= 10) {
            i += (num % 10);
            num /= 10;
        }
        i += num % 10;
        if (i >= 10) {
            return addDigits(i);
        }
        return i;
    }
}
