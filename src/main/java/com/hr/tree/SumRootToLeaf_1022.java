package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-21
 */
public class SumRootToLeaf_1022 {

    int rs;
    public int sumRootToLeaf(TreeNode root) {
        this.traversal(root, 0);
        return rs;
    }

    private void traversal(TreeNode root, int sum) {

        if (root == null) return;
        sum = sum * 2 + root.val;
        if (root.left == null && root.right == null) {
            rs += sum;
        }
        this.traversal(root.left, sum);
        this.traversal(root.right, sum);
    }
}
