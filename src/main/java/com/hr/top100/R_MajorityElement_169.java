package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class R_MajorityElement_169 {

    public int majorityElement(int[] nums) {

        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) ++count;
            else --count;
        }
        return num;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 2, 2};
        R_MajorityElement_169 instance = ReflectUtils.getInstance(R_MajorityElement_169.class);
        System.out.println(instance.majorityElement(nums));
    }
}
