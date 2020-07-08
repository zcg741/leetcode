package cn.zhangchg.leetcode.number;

import java.util.ArrayList;
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
 * [ 1,1,1,1,1]
 * [1,2,1,2,1]
 * [1,3.3,3,1]
 * [1,4,6,4,1]
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GenerateYh2 {

    public static void main(String[] args) {
        GenerateYh2 generateYh2 = new GenerateYh2();
        System.err.println(generateYh2.getRow(0));
        System.err.println(generateYh2.getRow(1));
        System.err.println(generateYh2.getRow(2));
        System.err.println(generateYh2.getRow(3));
        System.err.println(generateYh2.getRow(4));
        System.err.println(generateYh2.getRow2(4));
        System.err.println(generateYh2.getRow(5));
        System.err.println(generateYh2.getRow2(5));
        System.err.println(generateYh2.getRow(6));
        System.err.println(generateYh2.getRow2(6));
        long start = System.currentTimeMillis();
        System.err.println(generateYh2.getRow(100));
        System.err.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.err.println(generateYh2.getRow2(100));
        System.err.println(System.currentTimeMillis() - start);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        long nk = 1;
        for(int i = 0; i <= rowIndex; i++){
            list.add((int)nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return list;
    }

    public List<Integer> getRow2(int numRows) {

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
