package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class Rotate_77 {

    public void rotate_swap(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n >> 1); i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (j > i) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
