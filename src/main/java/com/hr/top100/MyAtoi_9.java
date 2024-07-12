package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-28
 */
public class MyAtoi_9 {

    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        if(!(isNumber(chars[0]) || isSignal(chars[0]) || chars[0] == ' ')) return 0;
        int low = 0;
        while(low < chars.length && chars[low] == ' ')
            ++low;
        if(low == chars.length) return 0;
        int signal = 1;
        if(isSignal(chars[low])) {
            if (chars[low] == '-') signal = -1;
            ++low;
        }
        int ans = 0;
        while(low < chars.length && isNumber(chars[low])){
            ans = ans * 10 + (chars[low] - '0') * signal;
            if(ans % 10 != (chars[low] - '0') * signal)  // 溢出
                return signal > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ++low;
        }
        return ans;
    }

    private boolean isSignal(char c){
        return c == '+' || c == '-';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
