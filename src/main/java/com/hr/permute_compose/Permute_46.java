package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class Permute_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        this.backtrace(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrace(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] flag) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) continue;
            list.add(nums[i]);
            flag[i] = true;
            this.backtrace(res, nums, list, flag);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {

        Permute_46 instance = ReflectUtils.getInstance(Permute_46.class);
        System.out.println(instance.permute(new int[] {1, 2, 3}));
    }
}
