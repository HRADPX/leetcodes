package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 *
 * x in [Integer.MIN_VALUE, Integer.MAX_VALUE]
 */
public class Reverse_7 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res * 10 / 10 != res) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
