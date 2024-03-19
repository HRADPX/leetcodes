package com.hr.double_pos;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-13
 */
public class SortTransformedArray_360 {

    public int[] SortTransformedArray(int[] nums, int a, int b, int c) {

        double mid = b / -2.0 / a;
        int low = 0, high = nums.length - 1;

        int[] rs = new int[nums.length];
        int k = a > 0 ? nums.length - 1 : 0;

        while (low <= high) {
            if (Math.abs(nums[high] - mid) > Math.abs(nums[low] - mid)) {
                rs[k] = a * nums[high] * nums[high] + b * nums[high] + c;
                high--;

            } else {
                rs[k] = a * nums[low] * nums[low] + b * nums[low] + c;
                low++;
            }
            k = a > 0 ? k - 1 : k + 1;
        }
        return rs;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -2, 2, 4};
        SortTransformedArray_360 instance = ReflectUtils.getInstance(SortTransformedArray_360.class);
        System.out.println(Arrays.toString(instance.SortTransformedArray(nums, -1, 3, 5)));
    }
}
