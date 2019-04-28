package cn.zhangchg.leetcode.string;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * <p>
 * <p>
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */

public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.err.println(numDecodings.numDecodings("226"));
        System.err.println(numDecodings.numDecodings("12"));
        System.err.println(numDecodings.numDecodings("10231123"));
    }

    public int numDecodings(String s) {
        if ("0".equals(s) || 0 == s.length()) {
            return 0;
        }
        if (1 == s.length()) {
            return 1;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
