package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 *
 * 给一个数组，移除重复的数，返回不同数的个数
 * [1,1,2,2,3]  -> 3
 */
public class RemoveDuplicates_26 {

    public int removeDuplicates(int[] nums) {

        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[k++] = nums[i];
        }
        return k;
    }
}
