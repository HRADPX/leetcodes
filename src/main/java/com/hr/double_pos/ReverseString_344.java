package com.hr.double_pos;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class ReverseString_344 {

    public void reverseString(char[] cs) {
        if (cs == null || cs.length <= 1)
            return;

        int low = 0;
        int high = cs.length - 1;

        while (low < high) {
            char c = cs[low];
            cs[low] = cs[high];
            cs[high] = c;
            low++;
            high--;
        }
    }
}
