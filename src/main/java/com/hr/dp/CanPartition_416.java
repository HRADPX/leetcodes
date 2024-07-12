package com.hr.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 *
 *
 * 0-1背包：
 * 416. 分割等和子集
 * 474. 一和零
 * 494. 目标和
 * 879. 盈利计划
 * 1049. 最后一块石头的重量 II
 * 1230. 抛掷硬币
 *
 * 完全背包：
 * 1449. 数位成本和为目标值的最大数字
 * 322. 零钱兑换
 * 518. 零钱兑换 II
 * 279. 完全平方数
 */
public class CanPartition_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;

        // ==> 找没有一个组合，和为 sum / 2
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        // 0-1背包，物品不可重复使用，物品在外循环，内循环倒序
        for (int num : nums) {
            for (int j = sum / 2; j >= 1; j--) {
                if (j >= num)
                    dp[j] |= dp[j - num];
            }
        }
        return dp[sum / 2];
    }
}
