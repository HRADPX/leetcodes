package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-27
 */
public class R_NumTrees_96 {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        // dp[i] = dp[i - 1] * dp[n - i]

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
