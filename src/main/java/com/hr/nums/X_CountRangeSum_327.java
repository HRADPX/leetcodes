package com.hr.nums;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-15
 *
 * 二分解法
 */
public class X_CountRangeSum_327 {

    // 超时
    public int countRangeSumUgly(int[] nums, int lower, int upper) {

        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long rangeSum = sum[j + 1] - sum[i];
                if (rangeSum >= lower && rangeSum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return this.countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }


    public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = (left + right) / 2;
        int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
        int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
        int ret = n1 + n2;

        // 首先统计下标对的数量
        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && sum[l] - sum[i] < lower) {
                l++;
            }
            while (r <= right && sum[r] - sum[i] <= upper) {
                r++;
            }
            ret += r - l;
            i++;
        }

        // 随后合并两个排序数组
        long[] sorted = new long[right - left + 1];
        int p1 = left, p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid) {
                sorted[p++] = sum[p2++];
            } else if (p2 > right) {
                sorted[p++] = sum[p1++];
            } else {
                if (sum[p1] < sum[p2]) {
                    sorted[p++] = sum[p1++];
                } else {
                    sorted[p++] = sum[p2++];
                }
            }
        }
        for (int j = 0; j < sorted.length; j++) {
            sum[left + j] = sorted[j];
        }
        return ret;
    }

    public static void main(String[] args) {

        X_CountRangeSum_327 instance = ReflectUtils.getInstance(X_CountRangeSum_327.class);
        int[] nums = {1};
        System.out.println(instance.countRangeSum(nums, 0, 0));
    }
}
