package com.hr.stock;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 *
 * 只能交易一次
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for(int price : prices){
            if(price > min) ans = Math.max(ans, price - min);
            else min = price;
        }
        return ans;
    }

    public int maxProfitV1(int[] prices) {
        // dp[i][0] 表示第i天不持有股票
        // dp[i][1] 表示第i天持有股票
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0; dp[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(-prices[i], dp[i][1]);
        }
        return dp[prices.length][0];
    }

    /**
     * 对 {@link #maxProfitV1(int[])} 的空间优化
     */
    public int maxProfitV2(int[] prices) {
         // 持有股票和不持有股票
         /// 动态规划
         int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
         for (int price : prices) {
             // 第 i 天不持有股票 = 第 i 天持有股票 + 第 i 天能卖的价格
             dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
             // 第 i 天持有股票 = 买入股票的价格
             dp_i_1 = Math.max(dp_i_1, -price);
         }
         return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit_121 instance = ReflectUtils.getInstance(MaxProfit_121.class);
        System.out.println(instance.maxProfitV2(prices));
        System.out.println(instance.maxProfitV1(prices));
    }
}
