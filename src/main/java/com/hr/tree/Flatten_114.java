package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class Flatten_114 {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        TreeNode left = this.dfs(root.left);
        TreeNode right = this.dfs(root.right);

        root.left = null;
        root.right = left;
        TreeNode node = root;
        while (node.right != null) node = node.right;
        node.right = right;
        return root;
    }
}
