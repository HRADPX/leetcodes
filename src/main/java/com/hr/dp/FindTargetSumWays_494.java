package com.hr.dp;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 *
 * 将数组拆分两个部分 S，T，使得 S + T = target
 */
public class FindTargetSumWays_494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum + target < 0 || (sum + target) % 2 == 1) return 0;
        int[] dp = new int[(sum + target) / 2 + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = dp.length - 1; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[dp.length - 1];
    }
}
