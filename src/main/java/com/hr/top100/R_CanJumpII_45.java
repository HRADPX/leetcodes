package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class R_CanJumpII_45 {

    public int canJump(int[] nums) {

//       int[] dp = new int[nums.length];
//       Arrays.fill(dp, nums.length);
//       dp[0] = 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i; j >= 0; j--) {
//                if (j + nums[j] >= i)
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//            }
//        }
//        return dp[nums.length - 1];
        // 2 3 1 1 4
        // cur 此轮跳跃能跳最远的
        int steps = 0, cur = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前轮跳跃能够跳到的最大位置
            cur = Math.max(cur, nums[i] + i);
            if (i == max) {
                ++steps;
                max = cur;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        R_CanJumpII_45 instance = ReflectUtils.getInstance(R_CanJumpII_45.class);
        System.out.println(instance.canJump(nums));
    }
}
