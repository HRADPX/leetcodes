package com.hr.path_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 */
public class R_PathSumIV_666 {

    int ans = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(int[] nums) {

        if (nums.length == 0) return 0;
        for (int num : nums) map.put(num / 10, num % 10);  // 存储节点和值
        dfs(nums[0] / 10, 0);
        return ans;
    }

    private void dfs(int node, int sum) {

        if (!map.containsKey(node)) return;
        sum += map.get(node);
        int depth = node / 10;
        int pos = node % 10;

        int left = (depth + 1) * 10 + pos * 2 - 1;
        int right = left + 1;

        if (!map.containsKey(left) && !map.containsKey(right)) ans += sum;
        else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}
