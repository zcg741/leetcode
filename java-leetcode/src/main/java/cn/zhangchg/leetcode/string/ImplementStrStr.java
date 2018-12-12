package cn.zhangchg.leetcode.string;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @author 张晨刚
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        //System.err.println(strStr("hello", "ll"));
        //System.err.println(strStr("aaaaa", "bba"));
        //System.err.println(strStr("a", "a"));
        //System.err.println(strStr("mississippi", "issip"));
        System.err.println(strStr("mississippi", "pi"));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        if(needle.length() >= haystack.length()){
            return -1;
        }
        int flag = 0;
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            int tempFlag = i + 1;
            for (char c1 : needle.toCharArray()) {
                if (c != c1) {
                    flag = 0;
                    break;
                }
                flag++;
                if (tempFlag == haystack.length()) {
                    if (flag == needle.length()) {
                        return i;
                    }
                    flag = 0;
                    break;
                }
                c = haystack.charAt(tempFlag++);
            }
            if (flag == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
