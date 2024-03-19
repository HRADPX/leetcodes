package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class SumNumbers_129 {

    int ans;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        this.dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null) return;
        cur = cur * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += cur;
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
