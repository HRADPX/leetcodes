package com.hr.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx != null) {
                return new int[]{idx + 1, i + 1};
            }
            map.put(target - nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
