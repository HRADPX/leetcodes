package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-12
 */
public class SortedSquares_977 {

    public int[] sortedSquares(int[] nums) {

        int low = 0, high = nums.length - 1, k = nums.length - 1;
        int[] res = new int[nums.length];

        while (low <= high) {

            if (Math.abs(nums[high]) > Math.abs(nums[low]))
                res[k--] = (int) Math.pow(nums[high--], 2);
            else
                res[k--] = (int) Math.pow(nums[low++], 2);
        }
        return res;
    }
}
