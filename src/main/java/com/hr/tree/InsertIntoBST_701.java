package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class InsertIntoBST_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = this.insertIntoBST(root.left, val);
        } else {
            root.right = this.insertIntoBST(root.right, val);
        }
        return root;
    }
}
