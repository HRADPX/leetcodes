package com.hr.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 */
public class R_NumTrees_96 {

    public int numTrees(int n) {
//        List<TreeNode> treeNodeList = this.dfs(1, n);
//        return treeNodeList.size();

        if (n < 1) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    // 超时...
    private List<TreeNode> dfs(int start, int end) {

        if (start > end) return Collections.singletonList(null);
        if (start == end) return Collections.singletonList(new TreeNode(start));

        List<TreeNode> rs = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = this.dfs(start, i - 1);
            List<TreeNode> rights = this.dfs(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    rs.add(root);
                }
            }
        }
        return rs;
    }
}
