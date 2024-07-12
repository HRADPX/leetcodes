package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-21
 */
public class R_SufficientSubset_1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean cut = sufficientSubset(root, limit, 0);
        return cut ? root : null;
    }

    private boolean sufficientSubset(TreeNode root, int limit, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val + sum >= limit;
        boolean left = this.sufficientSubset(root.left, limit, sum + root.val);
        boolean right = this.sufficientSubset(root.right, limit, sum + root.val);
        if (!left) root.left = null;
        if (!right) root.right = null;
        return left || right;
    }
}
