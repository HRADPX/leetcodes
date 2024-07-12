package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class Search_33 {

    // nums = [4,5,6,7,0,1,2], target = 0  ==> 4
    // 要求：时间复杂度为 O(logN)

    // 两次遍历
    // 先找到转换点，再通过二分查找...思路简单，但是需要遍历两次数组
    public int search_0(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        int mid = (low + high) >> 1;

        // 先找到转换点位置
        while(low < high){

            if(nums[mid] < nums[high])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid + 1;
            mid = (low + high) >> 1;
        }
        if(low == 0) return binarySearch(nums,target,0,nums.length - 1);
        if(nums[0] > target)
            return binarySearch(nums,target,low,nums.length - 1);
        return binarySearch(nums,target,0,low - 1);
    }

    private int binarySearch(int[] nums,int target,int low, int high) {
        while(low <= high){
            int mid = (low + high) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }


    // 二分变体，只遍历一次数组，但是需要考虑各种边界问题
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                // 3,4,5,6,7,0,1,2     0
                if (nums[low] > target && nums[mid] > nums[high]) low = mid + 1;
                else  high = mid - 1;
            } else {
                // 6,7,0,1,2,3,4,5
                if (nums[mid] < nums[high] && nums[high] < target) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {3,4,5,6,7,0,1,2};
        int[] nums = {6,7,0,1,2,3,4,5};
        Search_33 instance = ReflectUtils.getInstance(Search_33.class);
        System.out.println(instance.search(nums, 0));
        System.out.println(instance.search(nums, 1));
        System.out.println(instance.search(nums, 7));
    }
}
