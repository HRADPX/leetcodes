package com.hr.permute_compose;

import java.util.ArrayList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class Combine_77 {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> rs = new ArrayList<>();
        if (k <= 0 || n < k) {
            return rs;
        }
        List<Integer> list = new ArrayList<>();

        backtrace(n, 1, k, rs, list);
        return rs;
    }

    private void backtrace(int n, int low, int k, List<List<Integer>> rs, List<Integer> list) {

        if (list.size() == k) {
            rs.add(new ArrayList<>(list));
            return;
        }
        // 提前减枝
        for (int i = low; i <= n && list.size() + n - i + 1 >= k; i++) {
            list.add(i);
            this.backtrace(n, i + 1, k, rs, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        Combine_77 instance = ReflectUtils.getInstance(Combine_77.class);
        System.out.println(instance.combine(4, 3));
    }
}
