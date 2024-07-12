package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 */
public class ClimbStairs_70 {

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int pp = 1, p = 2, i = 3;
        while (i < n) {
            int temp = pp;
            pp = p;
            p += temp;
            i++;
        }
        return pp + p;
    }

    // 递归超时
    public int climbStairsV1(int n) {
        if (n == 1 || n == 2) return n;
        return climbStairsV1(n - 1) + climbStairsV1(n - 2);
    }

    public static void main(String[] args) {

        ClimbStairs_70 instance = ReflectUtils.getInstance(ClimbStairs_70.class);
        System.out.println(instance.climbStairs(16));
        System.out.println(instance.climbStairsV1(16));
    }
}
