package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-28
 */
public class R_FindDistance_1740 {

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) return 0;
        TreeNode ancestor = lowestCommonAncestor(root, p, q);
        return this.distance(ancestor, p) + this.distance(ancestor, q);
    }

    private int distance(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val == val) return 0;
        int left = this.distance(root.left, val);
        int right = this.distance(root.right, val);
        int distance = Math.max(left, right);
        return distance >= 0 ? distance + 1 : -1;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
