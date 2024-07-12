package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class CombinationSumII_40 {

    // 组合求和，数可以被选择一次
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        this.backtrace(candidates, res, 0, new ArrayList<>(), target);
        return res;
    }

    private void backtrace(int[] candidates, List<List<Integer>> res, int idx, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (idx == candidates.length) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            this.backtrace(candidates, res, i + 1, list, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        CombinationSumII_40 instance = ReflectUtils.getInstance(CombinationSumII_40.class);
        System.out.println(instance.combinationSum(candidates, 8));
    }
}
