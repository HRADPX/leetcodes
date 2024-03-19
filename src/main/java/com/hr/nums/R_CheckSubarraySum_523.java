package com.hr.nums;

import java.util.HashMap;
import java.util.Map;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 * 这题和 327 很像
 */
public class R_CheckSubarraySum_523 {

    // 暴力解法 超时
    public boolean checkSubarraySumUgly(int[] nums, int k) {

        if (nums.length <= 1) return false;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int rangeSum = sum[j + 1] - sum[i];
                if (j - i > 0 && rangeSum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length <= 1) return false;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        // 为什么加这个，防止 sum % k == 0
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {0,0};
        R_CheckSubarraySum_523 instance = ReflectUtils.getInstance(R_CheckSubarraySum_523.class);
        System.out.println(instance.checkSubarraySum(nums, 7));
    }
}
