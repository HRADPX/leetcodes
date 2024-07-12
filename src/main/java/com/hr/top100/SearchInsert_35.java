package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class SearchInsert_35 {

    public int searchInsert(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {3,3, 3, 3, 5};
        System.out.println(ReflectUtils.getInstance(SearchInsert_35.class).searchInsert(nums, 3));
    }
}
