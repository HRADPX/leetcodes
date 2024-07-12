package com.hr.binary_search;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-02
 */
public class MinEatingSpeed_875 {

    // piles = [3,6,7,11], h = 8  ==> 4
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = 1;
        for (int pile : piles) high = Math.max(pile, high);

        while (low < high) {
            int mid = (low + high) >>> 1;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
                if (hours > h) break;
            }
            if (hours > h)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {30,11,23,4,20};
        MinEatingSpeed_875 instance = ReflectUtils.getInstance(MinEatingSpeed_875.class);
        System.out.println(instance.minEatingSpeed(nums, 6));
    }
}
