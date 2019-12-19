package cn.zhangchg.leetcode.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * [1,5,10,10,5,1]
 * [1,6,15,20,15,6,1]
 * ]
 */
public class GenerateYh {

    public static void main(String[] args) {
        GenerateYh generateYh = new GenerateYh();
        List<List<Integer>> generate = generateYh.generate(9);
        System.err.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        if (numRows == 0) {
            return list;
        }
        list.add(Arrays.asList(1));
        if (numRows == 1) {
            return list;
        }
        for (int i = 1; i < numRows; i++) {
            list.add(getList(list.get(i - 1)));
        }
        return list;
    }

    public List<Integer> getList(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            list1.add(list.get(i) + list.get(i + 1));
        }
        list1.add(1);
        return list1;
    }

    public List<List<Integer>> generate1(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integerList);
        return generateNext(lists, numRows);
    }

    private List<List<Integer>> generateNext(List<List<Integer>> lists, int numRows) {
        if (0 == numRows) {
            return lists;
        }
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        List<Integer> list = lists.get(lists.size() - 1);
        for (int i = 0; i < list.size() - 1; i++) {
            integerList.add(list.get(i) + list.get(i + 1));
        }
        integerList.add(1);
        lists.add(integerList);
        return generateNext(lists, numRows - 1);
    }
}
