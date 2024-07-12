package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class NumSquares_279 {

    public int numSquares(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        for (int i = 0; i * i <= n; i++)
            dp[i * i] = 1;

        // pre end if necessary
        if (dp[n] == 1) return 1;

        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1) continue;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(ReflectUtils.getInstance(NumSquares_279.class).numSquares(12));
    }
}
