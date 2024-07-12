package com.hr.stack;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-04-02
 * 相似题：
 * 316. 去除重复字母(困难)
 * 321. 拼接最大数(困难)
 * 402. 移掉 K 位数字(中等)
 * 1081. 不同字符的最小子序列（中等）
 */
public class RemoveDuplicateLetters_316 {

    public String removeDuplicateLetters(String s) {

//        // bab
//        char[] cs = s.toCharArray();
//        int[] stack = new int[cs.length];
//        int[] count = new int[128];
//        for (char c : cs) count[c]++;
//        int top = -1;
//
//        // acdbc
//        // cbabc
//        for (int i = 0; i < cs.length; i++) {
//            boolean use = top == -1;
//            while (top != -1 && cs[stack[top]] >= cs[i] && count[cs[stack[top]]] > 1) {
//                count[cs[stack[top]]]--;
//                top--;
//                use = true;
//            }
//            if (use) stack[++top] = i;
//            else count[cs[i]]--;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j <= top; j++) sb.append(cs[stack[j]]);
//        return sb.toString();

        char[] cs = s.toCharArray();
        int[] counts = new int[26];
        // 参考上面的实现，用一个数组记录当前字符是否使用过，
        // 可以避免跳出循环是什么原因跳出的，是否需要加入到单调栈中
        boolean[] mask = new boolean[26];
        for (char c : cs) counts[c - 'a']++;

        int[] stack = new int[cs.length];
        int top = -1;

        // cbacdcbc
        for (int i = 0; i < cs.length; i++) {
            if (mask[cs[i] - 'a'] && --counts[cs[i] - 'a'] >= -1) continue;
            while (top != -1 && cs[i] < cs[stack[top]] && counts[cs[stack[top]] - 'a'] > 0) {
                mask[cs[stack[top--]] - 'a'] = false;
            }
            --counts[cs[i] - 'a'];
            stack[++top] = i;
            mask[cs[i] - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= top; i++) res.append(cs[stack[i]]);

        return res.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters_316 instance = ReflectUtils.getInstance(RemoveDuplicateLetters_316.class);
//        System.out.println(instance.removeDuplicateLetters("cbabc"));
        System.out.println(instance.removeDuplicateLetters("cbacdcbc"));
//        System.out.println(instance.removeDuplicateLetters("cbaabc"));
    }
}
