package cn.zhangchg.leetcode.number;

import java.util.*;
import java.util.function.Consumer;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author 张晨刚
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.err.println(generateParenthesis(1));
        System.err.println(generateParenthesis(2));
        System.err.println(generateParenthesis(3));
        System.err.println(generateParenthesis(4));

    }

    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generateParenthesis(c)) {
                    for (String right : generateParenthesis(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }

    public static List<String> generateParenthesis(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        Set<String> list = new HashSet<>();
        if (n == 1) {
            list.add("()");
            return new ArrayList<>(list);
        }
        List<String> strings = generateParenthesis(n - 1);
        strings.forEach(s -> {
            StringBuffer sb1 = new StringBuffer();
            sb1.append('(');
            sb1.append(s);
            sb1.append(')');
            list.add(sb1.toString());
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n; i++) {
            List<String> stringLefts = generateParenthesis(i);
            List<String> stringRights = generateParenthesis(n - i);
            stringLefts.forEach(sLeft -> {
                //if (!isSame(sLeft)) {
                    stringRights.forEach(sRight -> {
                        //if (sRight.length() != 2 || sLeft.length() != 2) {
                        //    if (!isSame(sRight)) {
                                StringBuffer sb1 = new StringBuffer();
                                sb1.append(sLeft);
                                sb1.append(sRight);
                                list.add(sb1.toString());
                            //}
                        //}
                    });
                //}
            });
        }
        return new ArrayList<>(list);
    }

    public static boolean isSame(String s) {
        if (s.length() == 2) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i++) == s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
