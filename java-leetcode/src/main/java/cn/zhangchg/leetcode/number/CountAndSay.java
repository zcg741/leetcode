package cn.zhangchg.leetcode.number;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * @author 张晨刚
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.err.println(countAndSay(1));
        System.err.println(countAndSay(2));
        System.err.println(countAndSay(3));
        System.err.println(countAndSay(4));
        System.err.println(countAndSay(5));
        System.err.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countStrSay(countAndSay(n - 1));
    }

    private static String countStrSay(String countAndSay) {
        if ("1".equals(countAndSay)) {
            return "11";
        }
        char[] chars = countAndSay.toCharArray();
        char charFlag = 0;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            if (charFlag == 0) {
                charFlag = aChar;
            }
            if (aChar != charFlag) {
                sb.append(i);
                sb.append(charFlag);
                i = 0;
                charFlag = aChar;
            }
            i++;
        }
        sb.append(i);
        sb.append(charFlag);
        return sb.toString();
    }
}