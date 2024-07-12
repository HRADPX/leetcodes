package com.hr.prefix_sum;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 *
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 */
public class MaxSubarraySumCircular_918 {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 0) return 0;

        // 结果有两种可能，最大子数组和在区间[i,j]，或者在[0,i]和[j,n)区间
        // 对于在区间[i,j]的场景，和 53 题相同
        // 对于在区间[0,i]和[j,n)，可以考虑取反，
        int max = nums[0], curMaxSum = 0;
        int min = nums[0], curMinSum = 0;
        int sum = 0;
        for (int num : nums) {
            curMaxSum += num;
            curMinSum += num;
            sum += num;
            min = Math.min(min, curMinSum);
            max = Math.max(max, curMaxSum);
            curMaxSum = Math.max(curMaxSum, 0);
            curMinSum = Math.min(curMinSum, 0);
        }
        if (max < 0) return max;  // max < 0 表示全部是负数，这时 max 就是最大的负数
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {

        int[] nums = {9,-4,-7,9};
        MaxSubarraySumCircular_918 instance = ReflectUtils.getInstance(MaxSubarraySumCircular_918.class);
        System.out.println(instance.maxSubarraySumCircular(nums));
    }
}
