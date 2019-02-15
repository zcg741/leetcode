package cn.zhangchg.leetcode.string;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 *
 * @author 张晨刚
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.err.println(lengthOfLastWord("Hello World"));
        System.err.println(lengthOfLastWord("World"));
        System.err.println(lengthOfLastWord("World  "));
        System.err.println(lengthOfLastWord("Wor  ld  "));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (length > 0) {
                    break;
                }
            } else {
                length++;
            }
        }
        return length;
    }
}
