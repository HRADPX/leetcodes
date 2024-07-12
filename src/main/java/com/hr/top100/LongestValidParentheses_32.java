package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-27
 */
public class LongestValidParentheses_32 {

    // 左右扫描
    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 1) return 0;
        int left, right, ans; ans = left = right = 0;

        char[] cs = s.toCharArray();

        for (char c : cs) {
            if (c == '(') ++left;
            else ++right;
            if (left == right) ans = Math.max(ans, left << 1);
            if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == ')') ++right;
            else ++left;
            if (left == right) ans = Math.max(ans, left << 1);
            if (left > right) left = right = 0;
        }
        return ans;
    }

    public int longestValidParenthesesStack(String s) {

        if (s == null || s.length() <= 1) return 0;
        int[] stack = new int[s.length() + 1];
        char[] cs = s.toCharArray();
        int top, ans; top = ans = 0;
        stack[0] = -1;

        for (int i = 0; i < cs.length; i++) {

            if (top != 0 && cs[i] == ')' && cs[stack[top]] == '(')
                ans = Math.max(ans, i - stack[--top]);
            else
                stack[++top] = i;
        }
        return ans;
    }
}
