package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-06-05
 */
public class IsUgly_263 {

    public boolean isUgly(int n) {

        if (n < 1) return false;
        if (n == 1) return true;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {

        IsUgly_263 instance = ReflectUtils.getInstance(IsUgly_263.class);
        System.out.println(instance.isUgly(14));
        System.out.println(instance.isUgly(4));
        System.out.println(instance.isUgly(5));
    }
}
