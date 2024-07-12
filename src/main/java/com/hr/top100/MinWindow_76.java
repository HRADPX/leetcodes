package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class MinWindow_76 {

    // 滑动窗口
    public String minWindow(String s, String t) {

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int[] tmap = new int[128];
        int[] smap = new int[128];
        int count = 0;  // 记录 t 不同字符的数量
        for (char c : tt) {
            if (++tmap[c] == 1) count++;
        }

        int low, high, start, end; low = start = 0; high = ss.length;

        // ADOBECODEBANC   ABC
        for (end = 0; end < ss.length; end++) {

            if (++smap[ss[end]] == tmap[ss[end]]) --count;
            if (count == 0) {
                // 左指针向前移动
                while (start <= end) {
                    if (tmap[ss[start]] == 0) {
                        start++;
                        continue;
                    }
                    if (end - start < high - low) {
                        high = end;
                        low = start;
                    }
                    if (--smap[ss[start]] < tmap[ss[start++]]) {
                        ++count;
                        break;
                    }
                }
            }
        }

        return high == ss.length ? "" : new String(ss, low, high - low + 1);
    }

    public static void main(String[] args) {

        String s = "ADBBBBECODEBANC";
        String t = "ABC";
        MinWindow_76 instance = ReflectUtils.getInstance(MinWindow_76.class);
        System.out.println(instance.minWindow(s, t));
    }
}
