package cn.zhangchg.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 *
 * @author 张晨刚
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int longestSubstring = 0;
        longestSubstring = lengthOfLongestSubstring("abcab!cbb");
        System.err.println(longestSubstring);
        longestSubstring = lengthOfLongestSubstring("bbbbb");
        System.err.println(longestSubstring);
        longestSubstring = lengthOfLongestSubstring("pwwkew");
        System.err.println(longestSubstring);

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = new char[s.length()];
        Map<Character,Boolean> characterMap = new HashMap<>();
        //int[] zmChars = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        //        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int start = 0, end = 0, length = 0;
        char[] charStrings = s.toCharArray();
        for (char charString : charStrings) {
            boolean isSame = false;
            int charInt = charString - 97;
            if (Boolean.TRUE.equals(characterMap.get(charString))) {
                isSame = true;
            }
            chars[end++] = charString;
            if (isSame) {
                for (int i = 0; i < chars.length; i++) {
                    if (charString == chars[start]) {
                        chars[start++] = '0';
                        break;
                    }
                    chars[start++] = '0';
                }
                int rightLengthOfLongestSubstring = lengthOfLongestSubstring(s.substring(start, s.length()));
                if (rightLengthOfLongestSubstring >= length) {
                    length = rightLengthOfLongestSubstring;
                    break;
                }
                break;
            }
            length++;
            characterMap.put(charString,Boolean.TRUE);
        }
        return length;
    }
}
