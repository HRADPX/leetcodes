package com.hr.stock;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-18
 *
 * 只能易两次
 */
public class MaxProfit_123 {

    public int maxProfit(int[] prices) {

        // dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
        // 最多只能进行两次交易
        // dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        // dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);

        // dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
        // dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);

        int[][][] dp = new int[prices.length + 1][2][2];
        dp[0][0][1] = Integer.MIN_VALUE; dp[0][1][1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0][0] = Math.max(dp[i][0][0], dp[i][0][1] + prices[i]);
            dp[i + 1][0][1] = Math.max(dp[i][0][1], - prices[i]);

            dp[i + 1][1][0] = Math.max(dp[i][1][0], dp[i][1][1] + prices[i]);
            dp[i + 1][1][1] = Math.max(dp[i][1][1], dp[i][0][0] - prices[i]);
        }
        return dp[prices.length][1][0];
    }

    /**
     * maxProfitOne: 只交易一次能获取到的最大利润
     */
    public int maxProfitV1(int[] prices) {

        int ans = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            ans = Math.max(ans, this.maxProfitOne(prices, 0, i) + this.maxProfitOne(prices, i + 1, prices.length - 1));
        }
        return ans;
    }

    public int maxProfitOne(int[] prices,int start,int end) {
        if(start >= end) return 0;
        int min = prices[start];
        int max = 0;
        for (int i = start + 1; i <= end; i++) {
            if(prices[i] < min){
                min = prices[i];
                continue;
            }
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        MaxProfit_123 instance = ReflectUtils.getInstance(MaxProfit_123.class);
        System.out.println(instance.maxProfit(prices));
    }
}
