package cn.zhangchg.leetcode.string;

/**
 * 72. 编辑距离
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author 张晨刚
 */
public class EditDistance {

    public static void main(String[] args) {
        System.err.println(minDistance("horse", "ros"));
        System.err.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }
        int[][] dp = new int[m + 1][n + 1];
        //dp[i+1][j+1]表示word1的前i个字符和word2的前j个字符的编辑距离
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]) + 1, dp[i][j] + tmp);
            }
        }
        return dp[m][n];
    }
}
