package com.hr.top100;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class MinDistance_72 {

    // 输入：word1 = "horse", word2 = "ros"
    //horse -> rorse (将 'h' 替换为 'r')
    //rorse -> rose (删除 'r')
    //rose -> ros (删除 'e')
    public int minDistance(String word1, String word2) {

        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int[][] dp = new int[cs1.length + 1][cs2.length + 1];

        for (int i = 1; i <= cs1.length; i++)
            dp[i][0] = i;
        for (int i = 1; i <= cs2.length; i++)
            dp[0][i] = i;

        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                if (cs1[i - 1] == cs2[j - 1])
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return dp[cs1.length][cs2.length];
    }

    public static void main(String[] args) {

        MinDistance_72 instance = ReflectUtils.getInstance(MinDistance_72.class);
        System.out.println(instance.minDistance("horse", "ros"));
    }
}
