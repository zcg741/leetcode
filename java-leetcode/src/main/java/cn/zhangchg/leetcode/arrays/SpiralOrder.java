package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 1,2,3,4,8,12,11,10,9,5,6,7,6
 *
 * @author 张晨刚
 */
public class SpiralOrder {


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] matrix2 = {
                {1},
                {2}
        };
        int[][] matrix3 = {
                {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}, {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}
        };
        System.err.println(JSONArray.toJSONString(matrix));
        List<Integer> integers = spiralOrder(matrix3);
        System.err.println(JSONArray.toJSONString(integers));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int[] matrix1 = matrix[0];
        int right = matrix1.length - 1, left = 0, bottom = matrix.length - 1, top = 0;
        for (int i = 0; list.size() < matrix.length * matrix[0].length; i++) {
            for (int j = left; j < right + 1; j++) {
                list.add(matrix[top][j]);
            }
            top++;
            for (int j = top; j < bottom + 1; j++) {
                list.add(matrix[j][right]);
            }
            right--;
            if (matrix.length - 1 - i > i) {
                for (int j = right; j > left - 1; j--) {
                    list.add(matrix[bottom][j]);
                }
            }
            bottom--;
            if (matrix1.length - 1 - i > i) {
                for (int j = bottom; j > top - 1; j--) {
                    list.add(matrix[j][left]);
                }
            }
            left++;
        }
        return list;
    }
}
