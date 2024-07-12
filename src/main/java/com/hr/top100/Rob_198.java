package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class Rob_198 {

    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(nums[i] + dp[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }

    private int maxRob(int[] nums) {
        int ans, p, pp; ans = p = pp = 0;
        for (int num : nums) {
            ans = Math.max(p, num + pp);
            pp = p;
            p = ans;
        }
        return ans;
    }

    public int rob2(int[] nums) {
        int ans, p, pp;
        ans = p = pp = 0;
        for (int num : nums) {
            ans = Math.max(ans + pp, p);
            pp = p;
            p = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Rob_198 instance = ReflectUtils.getInstance(Rob_198.class);
        System.out.println(instance.rob(new int[] {2,7,9,3,1}));
        System.out.println(instance.rob2(new int[] {2,7,9,3,1}));
        System.out.println(instance.maxRob(new int[] {2,7,9,3,1}));
//        System.out.println(instance.rob(new int[] {2}));
    }
}
