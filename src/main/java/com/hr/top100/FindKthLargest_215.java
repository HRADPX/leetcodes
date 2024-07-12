package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class FindKthLargest_215 {

    // 小根堆
    public int findKthLargest(int[] nums, int k) {
        for (int i = (k >> 1) - 1; i >= 0; i--)
            heapfiy(nums, i, k);

        for (int i = k; i < nums.length; i++) {
            if(nums[i] > nums[0]) {
                swap(nums,0, i);
                heapfiy(nums,0, k);
            }
        }
        return nums[0];
    }

    private void heapfiy(int[] nums, int i, int high) {

        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        int min = i;
        if(left < high && nums[left] < nums[min])
            min = left;
        if(right < high && nums[right] < nums[min])
            min = right;
        if(min != i){
            swap(nums,i,min);
            heapfiy(nums,min,high);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    // 快排算法
    public int findKthLargest2(int[] nums, int k) {
        return nums[findKthLargest2(nums,0,nums.length - 1, nums.length - k)];
    }

    private int findKthLargest2(int[] nums, int low, int high, int k) {
        if (low == high) return low;
        int index = partition(nums,low,high);
        if (index > k) return findKthLargest2(nums,low,index - 1, k);
        if (index < k) return findKthLargest2(nums,index + 1, high, k);
        return k;
    }

    private int partition(int[] nums, int low, int high) {
        int pivotKey = nums[(int) (Math.random() * (high - low + 1)) + low];
        int p1 = low - 1, p2 = high + 1, i = low;
        while (i < p2) {
            if (nums[i] < pivotKey)
                swap(nums, ++p1, i++);
            else if (nums[i] == pivotKey)
                ++i;
            else
                swap(nums, i, --p2);
        }
        return p1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};

        FindKthLargest_215 instance = ReflectUtils.getInstance(FindKthLargest_215.class);
        System.out.println(instance.findKthLargest(nums, 2));
    }
}
