package cn.zhangchg.leetcode.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GenerateYh2 {

    public static void main(String[] args) {
        GenerateYh2 generateYh2 = new GenerateYh2();
        List<Integer> generate = generateYh2.getRow(0);
        System.err.println(generate);
    }

    public List<Integer> getRow(int numRows) {

        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        return generateNext(integerList, numRows);
    }

    private List<Integer> generateNext(List<Integer> lists, int numRows) {
        if (0 == numRows) {
            return lists;
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        for (int i = 0; i < lists.size() - 1; i++) {
            integerList.add(lists.get(i) + lists.get(i + 1));
        }
        integerList.add(1);
        return generateNext(integerList, numRows - 1);
    }
}
