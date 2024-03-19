package com.hr.stock;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for(int price : prices){

            if(price > min) ans = Math.max(ans,price - min);
            else min = price;
        }
        return ans;
    }

    public int maxProfitV1(int[] prices) {
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
}
