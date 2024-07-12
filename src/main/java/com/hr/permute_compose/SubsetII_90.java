package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 * 包含重复元素的子集
 */
public class SubsetII_90 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        this.backtrace(nums, 0, list, res, new boolean[nums.length]);
        return res;
    }

    // 1 1 2  -> 1, 2, 11, 12, 112
    private void backtrace(int[] nums, int idx, List<Integer> list, List<List<Integer>> res, boolean[] flag) {

        res.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && !flag[i - 1] && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            flag[i] = true;
            this.backtrace(nums, i + 1, list, res, flag);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1};
        SubsetII_90 instance = ReflectUtils.getInstance(SubsetII_90.class);
        System.out.println(instance.subsets(nums));
    }
}
