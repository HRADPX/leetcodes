package com.hr.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 *
 * 最长公共序列，不要求连续
 *
 * s1 = "ace", s2 = "abcde"
 * --> 3
 */
public class LongestCommonSubsequence_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray();
        char[] cs2 = text2.toCharArray();

        int[][] dp = new int[cs2.length + 1][cs1.length + 1];

        for (int i = 1; i <= cs2.length; i++) {
            for (int j = 1; j <= cs1.length; j++) {

                if (cs2[i - 1] == cs1[j - 1])
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                else
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[cs2.length][cs1.length];
    }
}
