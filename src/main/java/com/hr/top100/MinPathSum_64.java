package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ArrayUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-26
 */
public class MinPathSum_64 {

    // [1, 3, 1]
    // [1, 5, 1]
    // [4, 2, 1]
    // 空间复杂度 O(M*N)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++)
            dp[i][0] += dp[i - 1][0] + grid[i][0];

        for (int i = 1; i < n; i++)
            dp[0][i] += dp[0][i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // [1, 2, 3]
    // [4, 5, 6]
    public int minPathSum_Opt(int[][] grid) {

        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++)
            dp[i] = dp[i - 1] + grid[0][i];
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                } else
                    dp[j] = dp[j] + grid[i][j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = ArrayUtils.parse2DoubleNums("[[1,2,3],[4,5,6]");
        System.out.println(ReflectUtils.getInstance(MinPathSum_64.class).minPathSum_Opt(grid));
    }
}
