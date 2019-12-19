package cn.zhangchg.leetcode.string;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入：['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * <p>
 * 示例 2：
 * <p>
 * 输入：['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 * Related Topics 双指针 字符串
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] chars = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString.reverseString(chars);
        System.err.println(chars);
        chars = new char[]{'h','e','l','l','o'};
        reverseString.reverseString(chars);
        System.err.println(chars);
    }
    public void reverseString(char[] s) {
        int l = 0,r = s.length - 1;
        while (l < r){
            char flag = s[l];
            s[l++] = s[r];
            s[r--] = flag;
        }
    }
}
