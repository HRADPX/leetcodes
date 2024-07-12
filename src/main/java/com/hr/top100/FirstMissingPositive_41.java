package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-28
 */
public class FirstMissingPositive_41 {

    // 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数
    // [3,4,0,1]
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[i] == 0 || idx >= nums.length || nums[idx] < 0) continue;
            nums[idx] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return nums.length + 1;
    }


    public int firstMissingPositive_dp(int[] nums) {
        boolean[] res = new boolean[nums.length + 1];
        int num = 0;
        for (int value : nums) {
            if (value <= 0) continue;
            if (value > nums.length) ++num;
            else res[value] = true;
        }
        if (num == nums.length) return 1;
        for (int i = 1; i < res.length; i++) {
            if (!res[i]) return i;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {

        int[] nums = {3,4,0,2};
        FirstMissingPositive_41 instance = ReflectUtils.getInstance(FirstMissingPositive_41.class);
        System.out.println(instance.firstMissingPositive(nums));
    }
}
