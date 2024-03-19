package com.hr.prefix_sum;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 */
public class PivotIndex_724 {

    public int pivotIndex(int[] nums) {

        if (nums.length <= 1) return nums.length - 1;
        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        // 1 2 3
        for (int i = 1; i <= nums.length; i++) {
            if (sum[i - 1] == sum[nums.length] - sum[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}
