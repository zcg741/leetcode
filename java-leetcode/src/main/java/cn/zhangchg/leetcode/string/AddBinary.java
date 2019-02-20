package cn.zhangchg.leetcode.string;

/**
 * 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author 张晨刚
 */
public class AddBinary {
    public static void main(String[] args) {
        System.err.println(addBinary("11", "1"));
        System.err.println(addBinary("1010", "1011"));
        System.err.println(addBinary("101", "1011"));
    }

    public static String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int ai = a.length();
        int bi = b.length();
        char[] chars = new char[bi];
        int flag = 0;
        int j = bi - 1;
        for (int i = ai - 1; i >= 0; i--, j--) {
            if ('1' == a.charAt(i) && '1' == b.charAt(j)) {
                if (flag == 1) {
                    chars[j] = '1';
                } else {
                    chars[j] = '0';
                }
                flag = 1;
            } else if ('0' == a.charAt(i) && '0' == b.charAt(j)) {
                if (flag == 1) {
                    chars[j] = '1';
                } else {
                    chars[j] = '0';
                }
                flag = 0;
            } else {
                if (flag == 1) {
                    chars[j] = '0';
                    flag = 1;
                } else {
                    chars[j] = '1';
                    flag = 0;
                }
            }
        }
        for (; j >= 0; j--) {
            if (flag == 0) {
                chars[j] = b.charAt(j);
            } else {
                if (b.charAt(j) == '1') {
                    chars[j] = '0';
                    flag = 1;
                } else {
                    chars[j] = '1';
                    flag = 0;
                }
            }
        }
        if (flag == 1) {
            return "1" + new String(chars);
        } else {
            return new String(chars);
        }
    }
}
