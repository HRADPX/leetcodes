package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 */
public class SS_RecoverTree_99 {

    TreeNode x, y, pre;

    public void recoverTree(TreeNode root) {
        this.inorder(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        this.inorder(root.left);
        if (pre != null && root.val < pre.val) {
            x = root;
            if (y == null) y = pre;
        }
        pre = root;
        this.inorder(root.right);
    }
}
