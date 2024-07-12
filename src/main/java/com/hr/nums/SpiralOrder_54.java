package com.hr.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> rs = new ArrayList<>(row * col);

        for (int i = 0; i <= ((Math.min(row, col) - 1) >>> 1); i++) {

            // up
            for (int j = i; j < col - i; j++)
                rs.add(matrix[i][j]);

            // right
            for (int j = i + 1; j < row - i; j++)
                rs.add(matrix[j][col - i - 1]);

            // bottom
            for (int j = col - i - 2; j >= i && row - i - 1 > i; j--)
                rs.add(matrix[row - i - 1][j]);

            // left
            for (int j = row - i - 2; j >= i + 1 && i < col - i - 1; j--)
                rs.add(matrix[j][i]);
        }
        return rs;
    }
}
