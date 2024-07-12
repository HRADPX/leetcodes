package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class FindDuplicate_287 {

    // 1 3 4 2 2
    // 3,1,3,4,2
    public int findDuplicate(int[] nums) {

        int fast, slow; slow = nums[0]; fast = nums[slow];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {

//        int[] nums = {2,5,9,6,9,3,8,9,7,1};
        int[] nums = {1,3,4,2,2};
        FindDuplicate_287 instance = ReflectUtils.getInstance(FindDuplicate_287.class);
        System.out.println(instance.findDuplicate(nums));
    }
}
