package com.hr.stock;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-18
 *
 * 交易k次
 */
public class MaxProfit_188 {

    public int maxProfit(int[] prices, int k) {
        // dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = 1; i <= k; i++)
            dp[0][i][1] = -prices[0];

        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][k][0];
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        MaxProfit_188 instance = ReflectUtils.getInstance(MaxProfit_188.class);
        System.out.println(instance.maxProfit(prices, 2));
    }
}
