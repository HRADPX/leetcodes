package com.hr.stock;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-18
 *
 * 可以交易多次，但是有冻结期
 */
public class MaxProfit_309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        MaxProfit_309 instance = ReflectUtils.getInstance(MaxProfit_309.class);
        System.out.println(instance.maxProfit(prices));
    }
}
