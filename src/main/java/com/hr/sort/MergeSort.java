package com.hr.sort;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-05
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        this.mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) >>> 1;
        
        this.mergeSort(nums, low, mid);
        this.mergeSort(nums, mid + 1, high);
    }
}
