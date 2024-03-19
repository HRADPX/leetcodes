package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetricV1(TreeNode root) {
        if (root == null) return true;
        boolean left = isSymmetricV1(root.left);
        boolean right = isSymmetricV1(root.right);
        if (!(left || right)) {
            return false;
        }
        if (root.left != null && root.right != null && root.left.val == root.right.val) {
            return true;
        }
        return root.left == null && root.right == null;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return this.isSymmetric(left.left, right.right) && this.isSymmetric(right.left, left.right);
    }
}
