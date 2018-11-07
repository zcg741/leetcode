package cn.zhangchg.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * abc def jhi jkl mno pqrs tuv wxyz
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author 张晨刚
 */
public class LetterCombinationsOfaPhoneNumber {

    public static void main(String[] args) {
        System.err.println(letterCombinations("23"));
        System.err.println(letterCombinations(""));
        System.err.println(letterCombinations("4"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return Collections.emptyList();
        }
        String[] strArr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            int parseInt = Integer.parseInt(String.valueOf(digits.charAt(i)));
            strList.add(strArr[parseInt - 2]);
        }
        String a = strList.get(strList.size() - 1);
        List<String> combination = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            combination.add(String.valueOf(a.charAt(i)));
        }
        for (int i = strList.size() - 2; i >= 0; i--) {
            combination = combination(strList.get(i), combination);
        }
        return combination;
    }

    public static List<String> combination(String str, List<String> strings) {
        List<String> combination = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            for (String string : strings) {
                combination.add(charAt + string);
            }
        }
        return combination;
    }
}
