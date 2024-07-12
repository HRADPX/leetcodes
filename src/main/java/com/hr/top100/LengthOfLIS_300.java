package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 *
 * 变体：找到这个最长的子序列
 * 二分法
 */
public class LengthOfLIS_300 {

    // 10,9,2,5,3,7,101,18
    // dp -> O(N*N)
    public int lengthOfLIS_Dp(int[] nums) {

        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // 2
    public int lengthOfLIS_BinarySearch(int[] nums) {

        int[] res = new int[nums.length];
        int idx = 0; res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int insertIdx = this.binarySearch(res, idx, nums[i]);
            if (insertIdx > idx) res[++idx] = nums[i];
            else res[insertIdx] = nums[i];
        }
        return idx + 1;
    }

    /**
     * 找到这个最长序列
     */
    public int[] lengthOfLIS(int[] nums) {

        int[] res = new int[nums.length];
        int idx = 0; res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 2 3 4 1 2 3 4
            int insertIdx = this.binarySearch(res, idx, nums[i]);
            if (insertIdx > idx) {
                res[++idx] = nums[i];
            }
            else res[insertIdx] = nums[i];
        }
        int max = idx;
        res[0] = nums[0]; idx = 0;
        for (int i = 1; i < nums.length; i++) {

            int insertIdx = this.binarySearch(res, idx, nums[i]);
            if (insertIdx > idx) res[++idx] = nums[i];
            else res[insertIdx] = nums[i];
            if (idx == max)  break;
        }
        int[] lis = new int[max + 1];
        System.arraycopy(res, 0, lis, 0, idx + 1);
        return lis;
    }

    private int binarySearch(int[] res, int high, int num) {
        int low = 0;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (res[mid] == num) return mid;
            if (res[mid] > num) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        System.out.println(Arrays.toString(ReflectUtils.getInstance(LengthOfLIS_300.class).lengthOfLIS(nums)));
        System.out.println(ReflectUtils.getInstance(LengthOfLIS_300.class).lengthOfLIS_Dp(nums));

    }
}
