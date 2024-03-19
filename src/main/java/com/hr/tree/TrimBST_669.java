package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class TrimBST_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return this.trimBST(root.right, low, high);
        if (root.val > high) return this.trimBST(root.left, low, high);
        root.left = this.trimBST(root.left, low, high);
        root.right = this.trimBST(root.right, low, high);
        return root;
    }
}
