package com.hr.top100;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class R_NextPermutation_31 {

    public void nextPermutation(int[] nums) {

        int left = nums.length - 2, right = nums.length - 1;

        // 4, 5, 3, 2
        // 2, 5, 4, 3
        while (left >= 0 && nums[left] >= nums[left + 1]) --left;
        if (left == -1) {
            this.reverse(nums);
            return;
        }
        while (right >= 0 && nums[right] <= nums[left]) --right;
        swap(nums, left, right);
        Arrays.sort(nums, left + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 3, 2};
        R_NextPermutation_31 instance = ReflectUtils.getInstance(R_NextPermutation_31.class);
        instance.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
