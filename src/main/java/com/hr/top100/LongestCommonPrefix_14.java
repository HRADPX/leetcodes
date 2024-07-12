package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length <= 1) return strs[0];
        int idx = 0; String ss = strs[0];
        outer: while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (idx == strs[i].length()) break outer;
                if (strs[i].charAt(idx) != ss.charAt(idx)) break outer;
            }
            idx++;
        }
        return ss.substring(0, idx);
    }

    public int[] next(char[] cs) {
        if (cs.length <= 0) return new int[0];
        int[] next = new int[cs.length];
        int value = -1;
        int i = 0;

        while (i < next.length - 1) {
            if (value == -1 || cs[i] == cs[value] )
                next[++i] = ++value;
            else
                value = next[value];
        }
        return next;
    }
}
