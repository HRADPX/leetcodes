package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class CanJump_55 {

    // 2,3,1,1,4
    //     t  t
    public boolean canJump(int[] nums) {

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
