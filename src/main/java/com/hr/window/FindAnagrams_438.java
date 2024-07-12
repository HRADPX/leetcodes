package com.hr.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class FindAnagrams_438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return Collections.emptyList();
        }

        List<Integer> rs = new ArrayList<>();
        char[] chars = s.toCharArray();

        int[] ss = new int[128];
        int[] tt = new int[128];

        for (char c : p.toCharArray())
            tt[c]++;

        int left = 0;
        int right;
        int count = p.length();

        for (int i = 0; i < chars.length; i++) {

            if (++ss[chars[i]] <= tt[chars[i]]) count--;
            if (count > 0) continue;

            right = i;

            while (left < right) {

                if (tt[chars[left]] == 0) {
                    left++;
                } else if (ss[chars[left]] > tt[chars[left]]) {
                    ss[chars[left]]--;
                    left++;
                } else {
                    break;
                }
            }
            if (right - left + 1 == p.length()) {
                rs.add(left);
            }
        }
        return rs;
    }
}
