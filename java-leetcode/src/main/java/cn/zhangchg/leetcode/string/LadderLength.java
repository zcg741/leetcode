package cn.zhangchg.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {

    public static void main(String[] args) {
        LadderLength ladderLength = new LadderLength();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordList.add("cot");
        System.err.println(ladderLength.ladderLength("qa", "sq", new ArrayList<>(Arrays.asList("sa","sq","ba","sb"))));
        //System.err.println(ladderLength.ladderLength("qa", "sq", new ArrayList<>(Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"))));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (checkOne(beginWord, endWord)) {
            return 2;
        }
        wordList.remove(endWord);
        Map<String, List<String>> word = findWord(wordList, endWord);
        int min = Integer.MAX_VALUE;
        for (String key : word.keySet()) {
            List<String> value = word.get(key);
            int length = ladderLength(beginWord, key, value);
            if (length - 1 > beginWord.length()) {
                return 0;
            }
            if (length == 0) {
                continue;
            }
            min = Math.min(min, length);
            System.err.println(key + "\t" + min + "\t" + value);
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return 1 + min;
    }

    private Map<String, List<String>> findWord(List<String> wordList, String endWord) {
        Map<String, List<String>> map = new HashMap<>();
        wordList.remove(endWord);
        wordList.forEach(word -> {
            boolean checkOne = checkOne(word, endWord);
            if (checkOne) {
                ArrayList<String> arrayList = new ArrayList<>(wordList);
                map.put(word, arrayList);
                System.err.println(word + "\t" + arrayList);
            }
        });
        return map;
    }

    private boolean checkOne(String word, String endWord) {
        int flag = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != endWord.charAt(i)) {
                flag++;
            }
            if (flag == 2) {
                return false;
            }
        }
        return true;
    }
}
