package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class MaxDepth_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = this.maxDepth(root.left);
        int right = this.maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    int rs;
    public int maxDepth_1(TreeNode root) {
        this.dfs(root, 0);
        return rs;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            rs = Math.max(rs, depth);
            return;
        }
        this.dfs(root.left, depth + 1);
        this.dfs(root.right, depth + 1);
    }
}
