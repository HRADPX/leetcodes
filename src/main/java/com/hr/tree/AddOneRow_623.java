package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-01
 */
public class AddOneRow_623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        this.dfs(null, root, 1, val, depth);
        return root;
    }

    private void dfs(TreeNode p, TreeNode root, int level, int val, int depth) {
        if (level > depth) return;
        if (depth == level) {
            if (p.left == root) {
                p.left = new TreeNode(val);
                p.left.left = root;
            } else {
                p.right = new TreeNode(val);
                p.right.right = root;
            }
            return;
        }
        if (root == null) return;
        this.dfs(root, root.left, level + 1, val, depth);
        this.dfs(root, root.right, level + 1, val, depth);
    }
}
