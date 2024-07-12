package com.hr.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 *
 * 最长回文串
 */
public class LongestPalindromeSubseq_516 {

    // aba
    //
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) return s.length();

        char[] cs = s.toCharArray();
        int[][] dp = new int[cs.length][cs.length];

        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j >= 0; j--) {

                if (i == j)
                    dp[j][i] = 1;
                else if (cs[j] == cs[i]) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                }

            }
        }
        return dp[0][cs.length - 1];
    }
}
