package com.hr.dp;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class NumSquares_279 {

    public int numSquares(int n) {

//        if (n <= 2) return n;
//
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, n);
//        for (int i = 1; i * i <= n; i++) dp[i * i] = 1;
//
//        if (dp[n] == 1) return 1;
//
//        // dp[i] =
//        for (int i = 1; i <= n; i++) {
//            if (dp[i] == 1) continue;
//            for (int j = i - 1; j >= 1; j--) {
//                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
//            }
//        }
//        return dp[n];

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

        NumSquares_279 instance = ReflectUtils.getInstance(NumSquares_279.class);
        System.out.println(instance.numSquares(15));
    }
}
