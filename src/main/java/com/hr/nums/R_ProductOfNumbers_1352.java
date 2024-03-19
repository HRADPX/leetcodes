package com.hr.nums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-15
 */
public class R_ProductOfNumbers_1352 {

    private List<Integer> products;

    public R_ProductOfNumbers_1352() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (products.size() <= k) {
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1 - k);
    }

}