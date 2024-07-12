package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res |= num;
        }
        return res;
    }
}
