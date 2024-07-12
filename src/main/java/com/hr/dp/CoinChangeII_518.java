package com.hr.dp;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 *
 * 零钱兑换
 */
public class CoinChangeII_518 {

    // 1, 2, 5   -> 5
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 完全背包，先物后背包，均正序遍历即可
        for (int coin : coins) {
            // 这里不能从 0 开始，不然会重复
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public static void main(String[] args) {

        CoinChangeII_518 instance = ReflectUtils.getInstance(CoinChangeII_518.class);
        System.out.println(instance.change(5, new int[] {1, 2, 5}));
    }
}
