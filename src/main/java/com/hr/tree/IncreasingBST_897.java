package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class IncreasingBST_897 {

    TreeNode pre;
    TreeNode rs;
    public TreeNode increasingBST(TreeNode root) {
        this.dfs(root);
        return rs;
    }

    public TreeNode increasingBSTV1(TreeNode root) {
        if (root == null) return null;
        TreeNode left = this.increasingBSTV1(root.left);
        TreeNode right = this.increasingBSTV1(root.right);
        if (left == null) {
            root.left = null;
            root.right = right;
            return root;
        }
        TreeNode cur = left;
        while (cur.right != null)
            cur = cur.right;
        root.left = null;
        cur.right = root;
        cur = cur.right;
        cur.right = right;
        return left;
    }


    private void dfs(TreeNode root) {
        if (root == null) return;
        this.dfs(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = null;
        }
        pre = root;
        if (rs == null) rs = root;
        this.dfs(root.right);
    }
}
