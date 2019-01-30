package cn.zhangchg.leetcode.arrays;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author 张晨刚
 */
public class SpiralOrder2 {


    public static void main(String[] args) {

        int[][] matrix = generateMatrix(2);
        System.err.println(JSONArray.toJSONString(matrix));
        matrix = generateMatrix(3);
        System.err.println(JSONArray.toJSONString(matrix));
        matrix = generateMatrix(4);
        System.err.println(JSONArray.toJSONString(matrix));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        List<Integer> list = new ArrayList<>();
        int[] matrix1 = matrix[0];
        int flag = 0;
        int right = matrix1.length - 1, left = 0, bottom = matrix.length - 1, top = 0;
        for (int i = 0; flag < n * n; i++) {
            for (int j = left; j < right + 1; j++) {
                matrix[top][j] = ++flag;
            }
            top++;
            for (int j = top; j < bottom + 1; j++) {
                matrix[j][right] = ++flag;
            }
            right--;
            for (int j = right; j > left - 1; j--) {
                matrix[bottom][j] = ++flag;
            }
            bottom--;
            for (int j = bottom; j > top - 1; j--) {
                matrix[j][left] = ++flag;
            }
            left++;
        }
        return matrix;
    }
}
