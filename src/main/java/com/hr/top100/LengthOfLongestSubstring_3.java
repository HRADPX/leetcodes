package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 */
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        char[] cs = s.toCharArray();
        int[] map = new int[256];
        int low, high, start, end; low = high = start = 0;

        for (end = 0; end < cs.length; end++) {

            map[cs[end]]++;
            while (start < end && map[cs[end]] > 1) {
                map[cs[start]]--;
                start++;
            }
            if (end - start > high - low) {
                high = end;
                low = start;
            }
        }
        return high - low + 1;
    }
}
