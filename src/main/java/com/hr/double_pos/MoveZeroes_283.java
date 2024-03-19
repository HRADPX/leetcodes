package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
