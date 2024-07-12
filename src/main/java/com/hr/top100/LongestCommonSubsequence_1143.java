package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-27
 */
public class LongestCommonSubsequence_1143 {

    public int longestCommonSubsequence(String s, String t) {

        if (s == null || s.length() <= 0 || t == null || t.length() <= 0) return 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int[][] dp = new int[ss.length + 1][tt.length + 1];
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < tt.length; j++) {
                if (ss[i] == tt[j]) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, Math.max(dp[i + 1][j], dp[i][j + 1]));
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }
        return dp[ss.length][tt.length];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence_1143 instance = ReflectUtils.getInstance(LongestCommonSubsequence_1143.class);
        System.out.println(instance.longestCommonSubsequence("abcdefoksejgr", "acefer"));
    }
}
