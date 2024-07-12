package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        this.backtrace(nums, 0, list, res);
        return res;
    }

    private void backtrace(int[] nums, int idx, List<Integer> list, List<List<Integer>> res) {

        res.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            this.backtrace(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        Subsets_78 instance = ReflectUtils.getInstance(Subsets_78.class);
        System.out.println(instance.subsets(nums));
    }
}
