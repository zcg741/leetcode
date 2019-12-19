package cn.zhangchg.leetcode.string;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * Related Topics 排序 哈希表
 */
public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.err.println(isAnagram.isAnagram("rat", "tar"));
        System.err.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.err.println(isAnagram.isAnagram("rat", "car"));
    }

    /**
     * .
     *
     * @param s
     * @param t
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[sarr[i]] = arr[sarr[i]]++;
            arr[tarr[i]] = arr[tarr[i]]--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 对比
     *
     * @param s
     * @param t
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] != tarr[i]) {
                return false;
            }
        }
        return true;
    }
}
