package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 */
public class MaxArea_11 {

    public int maxArea(int[] height) {

        if (height.length <= 1) return 0;
        int res = 0;
        int low, high; low = 0; high = height.length - 1;

        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            res = Math.max(res, area);
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return res;
    }
}
