package com.hr.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class MinInsertions_1312 {

    public int minInsertions(String s) {
        if (s.length() <= 1) return 0;

        char[] cs = s.toCharArray();
        int[][] dp = new int[cs.length][cs.length];

        for (int i = 1; i < cs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {

                if (cs[i] == cs[j] && i - j <= 1) continue;
                if (cs[i] == cs[j])
                    dp[j][i] = Math.min(dp[j + 1][i - 1], Math.min(dp[j][i - 1], dp[j + 1][i]) + 1);
                else {
                    if (i - j <= 1)
                        dp[j][i] = Math.min(dp[j][i - 1], dp[j + 1][i]) + 1;
                    else
                        dp[j][i] = Math.min(dp[j + 1][i - 1] + 2, Math.min(dp[j][i - 1], dp[j + 1][i]) + 1);
                }
            }
        }
        return dp[0][cs.length - 1];
    }
}
