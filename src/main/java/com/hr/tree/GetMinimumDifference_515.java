package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class GetMinimumDifference_515 {

    int ans = Integer.MAX_VALUE;
    TreeNode preTreeNode;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        this.inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {

        if (root == null) return;
        inorder(root.left);
        if (preTreeNode != null) {
            ans = Math.min(ans, root.val - preTreeNode.val);
        }
        preTreeNode = root;
        inorder(root.right);
    }
}
