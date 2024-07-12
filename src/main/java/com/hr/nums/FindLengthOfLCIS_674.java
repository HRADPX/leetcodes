package com.hr.nums;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class FindLengthOfLCIS_674 {

    public int findLengthOfLCIS(int[] nums) {

        int max = 1, count = 1, pre = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (pre < nums[i])
                max = Math.max(max, ++count);
            else
                count = 1;
            pre = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1};
        FindLengthOfLCIS_674 instance = ReflectUtils.getInstance(FindLengthOfLCIS_674.class);
        System.out.println(instance.findLengthOfLCIS(nums));
    }
}
