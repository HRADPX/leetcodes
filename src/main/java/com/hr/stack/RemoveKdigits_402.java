package com.hr.stack;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-07
 */
public class RemoveKdigits_402 {

    // 输入：num = "1432219", k = 3
    // 输出："1219"
    // 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
    // 示例 2 ：
    //
    // 输入：num = "987123", k = 4
    // 输出："12"
    public String removeKdigits(String num, int k) {

        if (num.length() <= k) return "0";
        char[] cs = num.toCharArray();

        int[] stack = new int[cs.length];
        int top = -1;

        for (int i = 0; i < cs.length; i++) {
            while (top != -1 && i - top - 1 < k && cs[stack[top]] > cs[i]) {
                top--;
            }
            if (top + 1 <= cs.length - k - 1)
                stack[++top] = i;
        }
        StringBuilder res = new StringBuilder();
        int idx = 0;
        top = Math.min(top, cs.length - k - 1);
        while (idx <= top && cs[stack[idx]] == '0') {
            ++idx;
        }
        if (idx > top) return "0";
        while (idx <= top) res.append(cs[stack[idx++]]);
        return res.toString();
    }

    public static void main(String[] args) {

        RemoveKdigits_402 instance = ReflectUtils.getInstance(RemoveKdigits_402.class);
        System.out.println(instance.removeKdigits("987123", 4));
        System.out.println(instance.removeKdigits("1432219", 3));
        System.out.println(instance.removeKdigits("10200", 1));
        System.out.println(instance.removeKdigits("112", 1));
    }
}
