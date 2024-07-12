package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-29
 */
public class MaximalRectangle_85 {


    public int maximalRectangle_dp(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        // 暴力法
        int[][] dp = new int[row][col];
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(j == 0 && matrix[i][j] == '1')
                    dp[i][j] = 1;
                else
                    dp[i][j] = matrix[i][j] == '1' ? dp[i][j - 1] + 1 : 0;
                // 如果当前位置不为 1，则以这个位置为右顶点的矩形面积为 0
                if(dp[i][j] == 0) continue;
                int min = dp[i][j];
                for(int m = i; m >= 0; m--) {
                    min = Math.min(min,dp[m][j]);
                    ans = Math.max(ans,(i - m + 1) * min);
                }
            }
        }
        return ans;
    }


    // ["1","0","1","0","0"],
    // ["1","0","1","1","1"],
    // ["1","1","1","1","1"],
    // ["1","0","0","1","0"]
    public int maximalRectangle(char[][] matrix) {


        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;

        // 最大面积法
        int ans = 0;
        int[] height = new int[col];
        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++)
                height[j] = chars[j] == '0' ? 0 : height[j] + 1;
            ans = Math.max(ans, maxArea(height));
        }
        return ans;
    }


    private int maxArea(int[] height){

        if(height.length == 0) return 0;
        int[] stack = new int[height.length + 1];
        stack[0] = -1;
        int pos = 0;
        int ans = 0;

        // 3 4 5 7 4
        for(int i = 0; i < height.length; i++){
            while(pos != 0 && height[i] < height[stack[pos]]){
                ans = Math.max(height[stack[pos--]] * (i - stack[pos] - 1), ans);
            }
            stack[++pos] = i;
        }
        while(pos != 0)
            ans = Math.max(height[stack[pos--]] * (height.length - stack[pos] - 1),ans);
        return ans;
    }
}
