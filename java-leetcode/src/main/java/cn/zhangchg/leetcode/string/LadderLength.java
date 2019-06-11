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
        //System.err.println(ladderLength.ladderLength("qa", "sq", new ArrayList<>(Arrays.asList("sa","sq","ba","sb"))));
        System.err.println(ladderLength.ladderLength("qa", "sq", new ArrayList<>(Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"))));
    }
    /*
     * 执行用时 : 65 ms, 在Word Ladder的Java提交中击败了90.05% 的用户
     * 内存消耗 : 37.4 MB, 在Word Ladder的Java提交中击败了93.40% 的用户
     * 这个解法是抄热评第一的，我之前以为就是个回溯问题，结果是bfs，对bfs还不太熟悉。
     */
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {
        /*
         * 这里是为了排除endWord不在wordList中的情况，不然下面遍历的时候endWord变化一位就
         * 在wordList中了。
         */
        if (!wordList.contains(endWord)) {
            return 0;
        }
        /*
         * bfs就是把每次筛选出来的节点保存到一个Set中，然后再次逐个遍历
         */
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        while (beginSet.size() > 0) {
            for (String b : beginSet) {
                wordList.remove(b);
            }
            step ++;
            Set<String> tempSet = new HashSet<>();
            for (String b : beginSet) {
                for (Iterator<String> iterator = wordList.iterator();
                     iterator.hasNext(); ) {
                    String w = iterator.next();
                    if (diff(b, w) > 1) {
                        continue;
                    } else {
                        if (endSet.contains(w)) {
                            return step;
                        } else {
                            tempSet.add(w);
                            /*
                             * 本来想提前遍历删除的，结果失败了
                             * 这里也要注意，在遍历List的时候删除有两种办法：
                             * 1. iterator 这里采用此种方法
                             * 2. 倒序遍历删除
                             */
//                            wordList.remove(w);
//                            iterator.remove();
                        }
                    }
                }
            }
            /*
             * 这里的tempSet其实是nextBeginSet, 判断一下从哪边走简单就从哪边走
             */
            if (tempSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = tempSet;
            } else {
                beginSet = tempSet;
            }
        }
        return 0;
    }

    private int diff(String w1, String w2) {
        int deviation = 0;
        for (int i = 0; i < w1.length() && deviation < 2; ++i) {
            if (w1.charAt(i) != w2.charAt(i)) {
                ++deviation;
            }
        }
        return deviation;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
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
