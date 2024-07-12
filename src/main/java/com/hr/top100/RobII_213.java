package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class RobII_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // 取偷第一个房子的值和偷最后一个房子的值的最大值
        return Math.max(this.maxRob(nums, 0, nums.length - 1), this.maxRob(nums, 1, nums.length));
    }

    private int maxRob2(int[] nums, int low, int high) {
        // ans 最终结果， p 前一个位置的， pp 前两个位置
        int ans, p, pp; ans = p = pp = 0;
        for (int i = low; i < high; i++) {
            ans = Math.max(p, nums[i] + pp);
            pp = p;
            p = ans;
        }
        return ans;
    }

    private int maxRob(int[] nums, int low, int high) {
        int ans = 0, cur = 0;
        for (int i = low; i < high; i++) {
            int temp = ans;
            ans = Math.max(ans, cur + nums[i]);
            cur = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        RobII_213 instance = ReflectUtils.getInstance(RobII_213.class);
        System.out.println(instance.rob(new int[] {2, 7, 9, 3, 1}));
    }
}
