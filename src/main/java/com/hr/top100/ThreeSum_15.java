package com.hr.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class ThreeSum_15 {

    // -4, -1, -1, 0, 1, 2
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[n - 1] + nums[n - 2] < 0) continue;
            int low = i + 1, high = n - 1, target = -nums[i];

            while (low < high) {
                if (nums[low] + nums[high] > target) high--;
                else if (nums[low] + nums[high] < target) low++;
                else {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++; high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        System.out.println(ReflectUtils.getInstance(ThreeSum_15.class).threeSum(nums));
    }
}
