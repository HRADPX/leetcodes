package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-21
 */
public class IsBalanced_110 {

    boolean rs = true;
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        this.depth(root);
        return rs;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (!rs) return -1;
        int left = this.depth(root.left);
        int right = this.depth(root.right);
        if (Math.abs(left - right) > 1) {
            rs = false;
        }
        return Math.max(left, right) + 1;
    }
}
