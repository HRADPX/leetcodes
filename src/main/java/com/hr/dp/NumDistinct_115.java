package com.hr.dp;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class NumDistinct_115 {

    // s = "rabbbit", t = "rabbit"  ==> 3
    // s = "babgbag", t = "bag"     ==> 5
    public int numDistinct(String s, String t) {

        if (s.length() < t.length()) return 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int[][] dp = new int[tt.length][ss.length];
        dp[0][0] = ss[0] == tt[0] ? 1 : 0;

        for (int i = 1; i < ss.length; i++) {
            dp[0][i] = dp[0][i - 1] + (ss[i] == tt[0] ? 1 : 0);
        }

        for (int i = 1; i < tt.length; i++) {
            for (int j = i; j < ss.length; j++) {
                if (tt[i] == ss[j])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[tt.length - 1][ss.length - 1];
    }

    public static void main(String[] args) {

        NumDistinct_115 instance = ReflectUtils.getInstance(NumDistinct_115.class);
        System.out.println(instance.numDistinct("babgbag", "bag"));
        System.out.println(instance.numDistinct("rabbbit", "rabbit"));
    }
}
