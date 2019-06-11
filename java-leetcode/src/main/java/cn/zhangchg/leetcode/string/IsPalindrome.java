package cn.zhangchg.leetcode.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author zhangchg
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();

        //System.err.println(isPalindrome.isPalindrome(""));
        //System.err.println(isPalindrome.isPalindrome(" "));
        //System.err.println(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        //System.err.println(isPalindrome.isPalindrome("race a car"));
        //System.err.println(isPalindrome.isPalindrome("0P"));
        //System.err.println(isPalindrome.isPalindrome("A"));
        //System.err.println(isPalindrome.isPalindrome("A "));
        System.err.println(isPalindrome.isPalindrome("`l;`` 1o1 ??;l`"));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < s.length() && checkChar(s.charAt(left))) {
            left++;
        }
        while (right > 0 && checkChar(s.charAt(right))) {
            right--;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if (leftChar >= 'A' && leftChar <= 'Z') {
                    leftChar += 32;
                } else {
                    leftChar -= 32;
                }
                if (leftChar != rightChar) {
                    return false;
                }
            }
            left++;
            right--;
            while (left < s.length() && checkChar(s.charAt(left))) {
                left++;
            }
            while (right > 0 && checkChar(s.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    public boolean checkChar(char c) {
        return (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9');
    }
}
