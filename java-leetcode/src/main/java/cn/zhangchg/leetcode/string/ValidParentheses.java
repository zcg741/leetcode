package cn.zhangchg.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 *
 * @author 张晨刚
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.err.println(isValid("()"));
        System.err.println(isValid("()[]{}"));
        System.err.println(isValid("(]"));
        System.err.println(isValid("([)]"));
        System.err.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.empty() || map.get(stack.pop()) != aChar) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
