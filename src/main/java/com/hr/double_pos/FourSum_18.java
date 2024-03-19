package com.hr.double_pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if ((nums[i] * 1L + nums[n - 1] + nums[n - 2] + nums[n - 3]) < target) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = n - 1;
                while (low < high) {
                    long sum = nums[i] * 1L + nums[j] + nums[low] + nums[high];
                    if (sum > target) high--;
                    else if (sum < target) low++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++; high--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        System.out.println(ReflectUtils.getInstance(FourSum_18.class).fourSum(nums, 1000000000));
    }
}
