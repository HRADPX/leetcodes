package com.hr.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-15
 */
public class R_RangeProductOfNumbers {

    private List<Integer> list;
    private List<Integer> cnt0; //前缀和记录0的个数

    public R_RangeProductOfNumbers() {
        list = new ArrayList<>();
        cnt0 = new ArrayList<>();
        list.add(1);
        cnt0.add(0);
    }

    public void add(int num) {
        if (num == 0) {
            list.add(1);
            cnt0.add(cnt0.get(cnt0.size() - 1) + 1);
        } else {
            list.add(list.get(list.size() - 1) * num);
            cnt0.add(cnt0.get(cnt0.size() - 1));
        }
    }

    public int getProduct(int k) {
        return getProduct(list.size() - k, list.size() - 1);
    }

    // 表示的是第s个元素到第e个元素间的乘积
    public int getProduct(int s, int e) {
        if (e < 1 || e >= list.size() || s < 1 || s >= list.size() || s > e) {
            throw new RuntimeException("Invalid input");
        }
        if (!cnt0.get(s - 1).equals(cnt0.get(e))) {
            return 0;
        }
        return list.get(e) / list.get(s - 1);
    }
}