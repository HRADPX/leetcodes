package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-27
 */
public class CanPartition_416 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;

        // ==> 找没有一个组合，和为 sum / 2
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;

        // 物品不能无限使用，外层物品，内层背包，内层倒序
        for (int num : nums) {
            for (int j = sum / 2; j >= 1; j--) {
                if (j >= num)
                    dp[j] |= dp[j - num];
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        CanPartition_416 instance = ReflectUtils.getInstance(CanPartition_416.class);
        System.out.println(instance.canPartition(new int[] {1,2,5}));
    }
}
