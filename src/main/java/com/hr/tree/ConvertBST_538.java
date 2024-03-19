package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-29
 */
public class ConvertBST_538 {

    public TreeNode convertBST(TreeNode root) {
        this.dfs(root);
        return root;
    }

    int sum;

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        this.dfs(root.right);
        sum += root.val;
        root.val = sum;
        this.dfs(root.left);
    }
}
