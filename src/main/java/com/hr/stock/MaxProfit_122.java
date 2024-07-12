package com.hr.stock;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-18
 *
 * 可以交易多次
 */
public class MaxProfit_122 {

    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length + 1][2];
//        dp[0][1] = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
//            dp[i + 1][1] = Math.max(dp[i][0] - prices[i], dp[i][1]);
//        }
//        return dp[prices.length][0];
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_0 - price, dp_i_1);
        }
        return dp_i_0;
    }

    public int maxProfit2(int[] prices) {
        int ans = 0;
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1])
                ans += prices[i + 1] - prices[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        MaxProfit_122 instance = ReflectUtils.getInstance(MaxProfit_122.class);
        System.out.println(instance.maxProfit(prices));
        System.out.println(instance.maxProfit2(prices));
    }
}
