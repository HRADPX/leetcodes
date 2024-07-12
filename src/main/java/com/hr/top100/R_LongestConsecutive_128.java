package com.hr.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-26
 */
public class R_LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num: nums) set.add(num);

        for (int num: nums) {

            int left = num - 1, right = num + 1, count = 1;
            while (set.remove(left)) {
                left--;
                count++;
            }
            while (set.remove(right)) {
                right++;
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
