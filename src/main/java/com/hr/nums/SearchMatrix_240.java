package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-02
 */
public class SearchMatrix_240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int col = matrix[0].length - 1;
        int m = matrix.length - 1, n = 0;
        while (m >= 0 && n <= col) {

            if (matrix[m][n] == target) return true;
            if (matrix[m][n] > target) --m;
            else ++n;
        }
        return false;
    }
}
