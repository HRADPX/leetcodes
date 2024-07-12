package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-27
 */
public class R_SortColors_75 {

    // 1,1,1,2,0,2
    public void sortColors(int[] nums) {

        if (nums.length <= 1) return;
        int low = 0, high = nums.length - 1, index = 0;

        while (index <= high) {
            if (nums[index] == 0) {
                nums[index++] = nums[low];
                nums[low++] = 0;
            } else if (nums[index] == 2) {
                nums[index] = nums[high];
                nums[high--] = 2;
            } else
                ++index;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        R_SortColors_75 instance = ReflectUtils.getInstance(R_SortColors_75.class);
        instance.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
