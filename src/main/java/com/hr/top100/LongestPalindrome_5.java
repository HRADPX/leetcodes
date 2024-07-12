package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-14
 */
public class LongestPalindrome_5 {

    // dp 或 双指针
    public String longestPalindromeDp(String s) {

        if (s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[cs.length][cs.length];

        // baba
        int low = 0, high = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) dp[j][i] = true;
                else if (cs[i] == cs[j] && i - j <= 2) dp[j][i] = true;
                else if (cs[i] == cs[j]) dp[j][i] = dp[j + 1][i - 1];
                if (dp[j][i]) {
                    if (i - j > high - low) {
                        high = i;
                        low = j;
                    }
                }
            }
        }
        return new String(cs, low, high - low + 1);
    }

    public String longestPalindrome(String s) {

        if (s.length() <= 1) return s;
        char[] cs = s.toCharArray();
//        int low = 0, high = 0;

        String res = "";
        for (int i = 0; i < cs.length * 2 - 1; i += 2) {
//            int max1 = this.longestPalindrome(cs, i >> 1, i >> 1);
//            int max2 = this.longestPalindrome(cs, i >> 1, (i >> 1) + 1);
//            if (high - low + 1 < max1) {
//                high = (i >> 1) + (max1 >> 1);
//                low = (i >> 1) - (max1 >> 1);
//            }
//            if (high - low + 1 < max2) {
//                high = (i >> 1) + (max2 >> 1);
//                low = (i >> 1) - (max2 >> 1) + 1;
//            }
            String max1 = this.longestPalindromeStr(cs, i >> 1, i >> 1);
            String max2 = this.longestPalindromeStr(cs, i >> 1, (i >> 1) + 1);
            res = max1.length() > res.length() ? max1 : res;
            res = max2.length() > res.length() ? max2 : res;
        }
//        return new String(cs, low, high - low + 1);
        return res;
    }

    private int longestPalindrome(char[] cs, int low, int high) {
        while (low >= 0 && high < cs.length && cs[low] == cs[high]) {
            low--; high++;
        }
        return high - low - 1;
    }

    private String longestPalindromeStr(char[] cs, int low, int high) {
        while (low >= 0 && high < cs.length && cs[low] == cs[high]) {
            low--; high++;
        }
        return new String(cs, low + 1, high - low - 1);
    }


    public static void main(String[] args) {
        LongestPalindrome_5 instance = ReflectUtils.getInstance(LongestPalindrome_5.class);
        System.out.println(instance.longestPalindrome("ababcbbc"));
    }
}
