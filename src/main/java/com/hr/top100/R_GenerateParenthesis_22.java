package com.hr.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-21
 *
 * dp解法...
 */
public class R_GenerateParenthesis_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, 0, 0, n, new char[n << 1], 0);
        return res;
    }

    public List<String> generateParenthesisDp(int n) {
        if (n <= 0) return Collections.emptyList();
        List<List<String>> dp = new ArrayList<>(n + 1);
        dp.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> dpi = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String s : dp.get(j)) {
                    for (String ss : dp.get(i - j - 1)) {
                        dpi.add("(" + s + ")" + ss);
                    }
                }
            }
            dp.add(dpi);
        }
        return dp.get(n);
    }

    /**
     * 入参不能使用 String，因为一次同时操作两个字符
     */
    public void dfs(List<String> res, int left, int right, int n, char[] cs, int idx) {
        if (left == n && right == n) {
            res.add(new String(cs));
            return;
        }
        if (left < right) return;
        if (left < n) {
            cs[idx] = '(';
            this.dfs(res, left + 1, right, n, cs, idx + 1);
        }
        if (right < n) {
            cs[idx] = ')';
            this.dfs(res, left, right + 1, n, cs, idx + 1);
        }
    }

    public static void main(String[] args) {
        R_GenerateParenthesis_22 instance = ReflectUtils.getInstance(R_GenerateParenthesis_22.class);
        System.out.println(instance.generateParenthesisDp(3));
        System.out.println(instance.generateParenthesis(3));
    }
}
