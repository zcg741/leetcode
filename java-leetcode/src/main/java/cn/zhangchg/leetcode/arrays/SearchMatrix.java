package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * @author 张晨刚
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.err.println(JSONArray.toJSONString(matrix));
        searchMatrix(new int[][]{new int[]{1}}, 3);
        System.err.println(searchMatrix(matrix, 15));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrix(matrix, 0, matrix.length - 1, target);
    }


    public static boolean searchMatrix(int[][] matrix, int start, int end, int target) {
        if (end - start < 0) {
            return false;
        }
        int left = (start + end) / 2;
        if (matrix[left][0] <= target && matrix[left][matrix[left].length - 1] >= target) {
            return searchMatrix(matrix[left], 0, matrix[left].length, target);
        } else if (matrix[left][0] > target) {
            return searchMatrix(matrix, start, left - 1, target);
        } else if (matrix[left][0] < target) {
            return searchMatrix(matrix, left + 1, end, target);
        }
        return false;
    }


    public static boolean searchMatrix(int[] matrix, int start, int end, int target) {
        if (end - start < 0) {
            return false;
        }
        int left = (start + end) / 2;

        if (matrix[left] == target) {
            return true;
        } else if (matrix[left] > target) {
            return searchMatrix(matrix, start, left - 1, target);
        } else if (matrix[left] < target) {
            return searchMatrix(matrix, left + 1, end, target);
        }
        return false;
    }
}
