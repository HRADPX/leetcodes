package com.hr.top100;

import java.util.Collections;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-25
 */
public class WordBreak_139 {

    // s = "applepenapple", wordDict = ["apple", "pen"]
    public boolean wordBreak(String s, List<String> wordDict) {

        int max = 0;
        for (String ss : wordDict) {
            max = Math.max(max, ss.length());
        }

        char[] cs = s.toCharArray();
        boolean[] dp = new boolean[cs.length + 1];
        dp[0] = true;

        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j >= 0 && i - j + 1 <= max; j--) {
                if (!dp[i + 1] && wordDict.contains(new String(cs, j, i - j + 1))) {
                    dp[i + 1] |= dp[j];
                }
            }
        }
        return dp[cs.length];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {

        int max = 0;
        for (String s1 : wordDict) max = Math.max(max, s1.length());

        char[] cs = s.toCharArray();
        boolean[] dp = new boolean[cs.length + 1];
        dp[0] = true;

        for (int i = 0; i < cs.length; i++) {
            for (int j = i; j >= 0 && i - j + 1 <= max; j--) {
                if (!dp[i + 1] && wordDict.contains(new String(cs, j, i - j + 1)))
                    dp[i + 1] |= dp[j];
            }
        }
        return dp[cs.length];
    }

    public static void main(String[] args) {

        List<String> wordDict = Collections.singletonList("a");
        WordBreak_139 instance = ReflectUtils.getInstance(WordBreak_139.class);
        System.out.println(instance.wordBreak("a", wordDict));
    }
}
