package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class StrStr_28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.length() < needle.length()) return -1;
        int p = 0; int q = 0; int s = 0;
        char[] ps = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        // leetcode leetc
        while (p < ps.length && q < ns.length) {
            if (ps[p] != ns[q]) {
                p = ++s; q = 0;
            } else {
                ++p; ++q;
            }
        }
        if (q == ns.length) return s;
        return -1;
    }

    public int[] next(char[] cs) {

        if (cs == null) return new int[0];
        int value = -1, i = 0;
        int[] next = new int[cs.length];

        while (i < cs.length - 1) {

            if (value == -1 || cs[i] == cs[value]) {
                next[++i] = ++value;
            } else {
                value = next[value];
            }
        }
        return next;
    }
}
