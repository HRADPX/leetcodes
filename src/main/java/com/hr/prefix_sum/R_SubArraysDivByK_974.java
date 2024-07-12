package com.hr.prefix_sum;

import java.util.HashMap;
import java.util.Map;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-19
 *
 * 相似题：
 *  523. 连续子数组和
 */
public class R_SubArraysDivByK_974 {

    // 暴力超时
    public int subarraysDivByKUgly(int[] nums, int k) {

        if (nums.length <= 0) return 0;
        int ans = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int rangeSum = sum[j + 1] - sum[i];
                if (rangeSum % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraysDivByK(int[] nums, int k) {

        int sum = 0, ans = 0;
        // map 可以优化为长度为 k 的数组
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            sum = (sum % k + k) % k;
            if (map.containsKey(sum))
                ans += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 0, -2, -3, 1};
        R_SubArraysDivByK_974 instance = ReflectUtils.getInstance(R_SubArraysDivByK_974.class);
        System.out.println(instance.subarraysDivByK(nums, 5));
        System.out.println(-1%5 + 5);
    }

}
