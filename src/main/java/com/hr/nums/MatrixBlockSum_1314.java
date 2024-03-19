package com.hr.nums;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-15
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 *
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 *
 * k = 1
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 输出：
 * 12,21,16
 * 27,45,33
 * 24,39,28
 *
 *   0,2
 *   0,2
 */
public class MatrixBlockSum_1314 {

    public int[][] matrixBlockSum(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] sum = new int[rows + 1][cols + 1];
        int[][] res = new int[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int row1 = Math.max(0, i - k);
                int col1 = Math.max(0, j - k);
                int row2 = Math.min(rows - 1, i + k);
                int col2 = Math.min(cols - 1, j + k);
                res[i][j] = sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4,5,6}, {7, 8, 9}};
        MatrixBlockSum_1314 instance = ReflectUtils.getInstance(MatrixBlockSum_1314.class);
        for (int[] ints : instance.matrixBlockSum(matrix, 1)) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
