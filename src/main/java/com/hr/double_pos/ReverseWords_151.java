package com.hr.double_pos;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class ReverseWords_151 {

    public String reverseWords(String s) {
        if (s.length() <= 1) return s;

        char[] cs = s.toCharArray();
        int idx = 0; boolean space = true;

        for (int i = 0; i < cs.length; i++) {
            if (space && cs[i] == ' ') continue;
            space = cs[i] == ' ';
            cs[idx++] = cs[i];
        }
        // "hello word  ";
        while (idx >= 0 && cs[--idx] == ' ') idx--;

        int low = 0;
        for (int i = 0; i <= idx; i++) {

            if (cs[i] == ' ') {
                this.reverse(cs, low, i - 1);
                low = i + 1;
            }
        }
        this.reverse(cs, low, idx);
        this.reverse(cs, 0, idx);
        return new String(cs, 0, idx + 1);
    }

    private void reverse(char[] cs, int low, int high) {

        while (low < high) {
            char temp = cs[low];
            cs[low++] = cs[high];
            cs[high--] = temp;
        }
    }

    public static void main(String[] args) {

        System.out.println(ReflectUtils.getInstance(ReverseWords_151.class).reverseWords("a good   example"));
    }
}
