package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class IsValidBST_98 {

    TreeNode val;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST(root.left);
        if (!left) return false;
        if (val != null && val.val >= root.val)
            return false;
        else
            val = root;
        return isValidBST(root.right);
    }


    boolean rs = true;
    public boolean isValidBSTV1(TreeNode root) {
        this.inorder(root);
        return rs;
    }

    private void inorder(TreeNode root) {
        if (!rs) return;
        if (root == null) return;
        this.inorder(root.left);
        if (val != null && val.val >= root.val) {
            rs = false;
            return;
        } else
            val = root;
        this.inorder(root.right);
    }
}
