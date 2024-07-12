package com.hr.utils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-27
 */
public class KmpUtils {

    public static int kmp(String s, String p) {
        if (s == null || p == null) return -1;
        if (p.length() == 0) return 0;
        if (s.length() == 0 || s.length() < p.length()) return -1;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int sIndex = 0, pIndex = 0;
        int[] next = getNext(pp);

        while (sIndex < ss.length && pIndex < pp.length) {
            if (ss[sIndex] == pp[pIndex]) {
                ++sIndex; ++pIndex;
            } else {
                if (pIndex == 0) ++sIndex;
                else pIndex = next[pIndex];
            }
        }
        if (pIndex == pp.length) return sIndex - pIndex;
        return -1;
    }

    public static int[] getNext(char[] cs) {
        if (cs.length == 0) return new int[0];
        int[] next = new int[cs.length];

        int value = -1, i = 0;

        while (i < cs.length - 1) {
            if (value == -1 || cs[i] == cs[value])
                next[++i] = ++value;
            else
                value = next[value];
        }
        return next;
    }
}
