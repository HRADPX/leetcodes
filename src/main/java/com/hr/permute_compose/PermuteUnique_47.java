package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class PermuteUnique_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> rs = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        Arrays.sort(nums);

        backtrace(nums,  flag, rs, list);
        return rs;
    }

    private void backtrace(int[] nums, boolean[] flag, List<List<Integer>> res, List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            if (i > 0 && !flag[i - 1] && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            flag[i] = true;
            this.backtrace(nums, flag, res, list);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        PermuteUnique_47 instance = ReflectUtils.getInstance(PermuteUnique_47.class);
        System.out.println(instance.permuteUnique(nums));
    }
}
