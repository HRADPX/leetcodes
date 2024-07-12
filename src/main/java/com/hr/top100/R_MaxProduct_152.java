package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class R_MaxProduct_152 {

    public int maxProduct(int[] nums) {

        int max = 0, imax = 1, imin = 1;

        for (int num : nums) {
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(num, imax * num);
            imin = Math.min(num, imin * num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
