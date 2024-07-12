package com.hr.binary_search;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-02
 *
 * 将数组分为 k 个和相等的子数组
 * low = Math.max(low, num)
 * max = sum(nums)
 */
public class R_SplitArray_410 {

    // nums = [7,2,5,10,8], k = 2 ==> 18
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(num, low); // 最小和
            high += num;              // 最大和
        }
        if (k == 1) return high;

        while (low < high) {
            int mid = (low + high) >> 1;
            int cur = 0;
            int count = 1;

            for (int num : nums) {
                cur += num;
                if (cur > mid) {
                    count++;
                    cur = num;
                }
                if (count > k) {
                    break;
                }
            }
            if (count > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
