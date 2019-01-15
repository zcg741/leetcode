package cn.zhangchg.leetcode.arrays;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 在真实的面试中遇到过这道题？
 *
 * @author 张晨刚
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        System.err.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Collections.emptyList();
        }
        List<List<String>> lists = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = Arrays.asList(strs);
            lists.add(list);
            return lists;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sortString = new String(chars);
            if (map.containsKey(sortString)) {
                List<String> stringList = map.get(sortString);
                stringList.add(string);
            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                map.put(sortString, list);
            }
        }
        lists.addAll(map.values());
        return lists;
    }

}
