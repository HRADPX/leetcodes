package com.hr.window;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class CheckInclusion_567 {

    // s1 = "ab" s2 = "eidbaooo"
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int count = 0; int[] map = new int[128];
        char[] cs = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            if (++map[s1.charAt(i)] == 1) ++count;
        }

        int low = 0, high; int[] smap = new int[128];
        for (high = 0; high < cs.length; high++) {

            if (map[cs[high]] == 0) continue;
            if (++smap[cs[high]] == map[cs[high]]) {
                --count;
            }
            if (count > 0) continue;
            while (low < high) {
                if (map[cs[low]] == 0) {
                    low++;
                    continue;
                }
                if (smap[cs[low]] > map[cs[low]]) {
                    smap[cs[low]]--;
                    low++;
                } else
                    break;
            }
            if (high - low + 1 == s1.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        CheckInclusion_567 instance = ReflectUtils.getInstance(CheckInclusion_567.class);
        System.out.println(instance.checkInclusion("adc", "dcda"));
    }
}
