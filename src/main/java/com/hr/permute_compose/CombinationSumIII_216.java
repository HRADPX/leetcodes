package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class CombinationSumIII_216 {

    // 组合求和，数可以被重复选择
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        this.backtrace(n, res, 1, new ArrayList<>(), k);
        return res;
    }

    private void backtrace(int n, List<List<Integer>> res, int idx, List<Integer> list, int k) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (n < i) break;
            list.add(i);
            this.backtrace(n - i, res, i + 1, list, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSumIII_216 instance = ReflectUtils.getInstance(CombinationSumIII_216.class);
        System.out.println(instance.combinationSum3(3, 9));
    }
}
