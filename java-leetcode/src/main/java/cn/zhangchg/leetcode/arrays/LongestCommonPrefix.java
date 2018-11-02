package cn.zhangchg.leetcode.arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author 张晨刚
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.err.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.err.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    /**
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }else if(strs.length == 1){
            return strs[0];
        }
        int minLenght = strs[0].length();
        for (String str : strs) {
            minLenght = Math.min(str.length(), minLenght);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLenght; i++) {
            char isSame = strs[0].charAt(i);
            for (String str : strs) {
                if (isSame != str.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(isSame);
        }
        return sb.toString();
    }
}
