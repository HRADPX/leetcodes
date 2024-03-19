package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class SumOfLeftLeaves_404 {

    int rs;
    public int sumOfLeftLeaves(TreeNode root) {
        this.dfs(root);
        return rs;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null)
            rs += root.left.val;
        dfs(root.left);
        dfs(root.right);
    }
}
