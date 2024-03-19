package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-21
 */
public class RangeSumBST_938 {

    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.traversal(root, low, high);
        return sum;
    }

    private void traversal(TreeNode root, int low, int high) {

        if (root == null) return;
        if (root.val > high) {
            this.traversal(root.left, low, high);
            return;
        }
        if (root.val < low) {
            this.traversal(root.right, low, high);
            return;
        }
        sum += root.val;
        this.traversal(root.left, low, high);
        this.traversal(root.right, low, high);
    }

    public int rangeSumBSTV1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) {
            return this.rangeSumBSTV1(root.right, low, high);
        }
        if (root.val > high) {
            return this.rangeSumBSTV1(root.left, low, high);
        }
        return root.val + this.rangeSumBSTV1(root.right, low, high) + this.rangeSumBSTV1(root.left, low, high);
    }
}
