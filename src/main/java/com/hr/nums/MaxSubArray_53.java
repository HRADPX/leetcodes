package com.hr.nums;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 *
 * 相似题：
 * 2606. 找到最大开销的子字符串 1422
 * 1749. 任意子数组和的绝对值的最大值 1542
 * 1191. K 次串联后最大子数组之和 1748
 * 918. 环形子数组的最大和 1777
 * 2321. 拼接数组的最大分数 1791
 * 1186. 删除一次得到子数组最大和 1799
 * 363. 矩形区域不超过 K 的最大数值和
 * 974. 和可被 K 整除的子数组
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {

        int max = nums[0], curSum = 0;
        for (int num : nums) {
            curSum += num;
            max = Math.max(max, curSum);
            if (curSum < 0) curSum = 0;
        }
        return max;
    }
}
