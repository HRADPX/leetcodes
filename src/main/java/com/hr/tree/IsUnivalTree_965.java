package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class IsUnivalTree_965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return this.traversal(root, root.val);
    }

    private boolean traversal(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return this.traversal(root.left, val) && this.traversal(root.right, val);
    }
}
