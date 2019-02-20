package cn.zhangchg.leetcode.arrays;

import java.util.Arrays;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author 张晨刚
 */
public class PlusOne {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.err.println(Arrays.toString(plusOne(new int[]{9, 2, 3})));
        System.err.println(Arrays.toString(plusOne(new int[]{9, 2, 9})));
        System.err.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        int flag = 1;
        for (int i = digits.length - 1; i >= 0 && flag != 0; i--) {
            digits[i] = digits[i] + flag;
            if (digits[i] == 10) {
                flag = 1;
                digits[i] = 0;
            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            int[] digits1 = new int[digits.length + 1];
            digits1[0] = 1;
            System.arraycopy(digits, 0, digits1, 1, digits.length);
            return digits1;
        } else {
            return digits;
        }
    }

    public static int[] plusOne2(int[] digits) {
        int[] digits1 = new int[digits.length + 1];
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits1[i + 1] = digits[i] + flag;
            if (digits1[i + 1] == 10) {
                flag = 1;
                digits1[i + 1] = 0;
            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            digits1[0] = 1;
            return digits1;
        } else {
            return Arrays.copyOfRange(digits1, 1, digits1.length);
        }
    }
}
