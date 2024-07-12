package com.hr.top100;

import java.util.Arrays;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-26
 */
public class SetZeroes_73 {

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        boolean firstRow, firstCol; firstRow = firstCol = false;
        if (matrix[0][0] == 0) {
            firstCol = firstRow = true;
        }
        if (!firstRow) {
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[i][0] == 0) {
                    firstRow = true;
                    break;
                }
            }
        }
        if (!firstCol) {
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[0][i] == 0) {
                    firstCol = true;
                    break;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRow) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
