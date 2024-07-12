package com.hr.dp;

import java.util.Map;

import com.hr.utils.ArrayUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class MinFallingPathSum_931 {

    public int minFallingPathSum(int[][] matrix) {

        // dp
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            dp[0][i] = matrix[0][i];


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + matrix[i][j];
                if (j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], Math.min( dp[i][j], dp[i - 1][j + 1] + matrix[i][j]));
                }
            }
        }
        for (int value : dp[m - 1]) res = Math.min(res, value);
        return res;


        // 记忆 + 回溯
//        int res = Integer.MAX_VALUE;
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < matrix[0].length; i++) {
//            res = Math.min(res, this.backtrace(matrix, 0, i, map, 0));
//        }
//        return res;
    }

    private int backtrace(int[][] matrix, int row, int col, Map<String, Integer> map, int sum) {

        if (row >= matrix.length) return sum;
        if (row < 0 || col < 0 || col >= matrix[0].length) {
            return Integer.MAX_VALUE - 1000001;
        }
        String key = String.format("%s_%s", row, col);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int down = this.backtrace(matrix, row + 1, col, map, sum);
        int right = this.backtrace(matrix, row + 1, col + 1, map, sum);
        int left = this.backtrace(matrix, row + 1, col - 1, map, sum);

        int res = Math.min(down, Math.min(left, right)) + matrix[row][col];
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = ArrayUtils.parse2DoubleNums("[[-80,-13,22],[83,94,-5],[73,-48,61]]");
        MinFallingPathSum_931 instance = ReflectUtils.getInstance(MinFallingPathSum_931.class);
        System.out.println(instance.minFallingPathSum(matrix));
    }
}
