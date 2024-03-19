package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class R_RecoverTree_99 {

    TreeNode x;
    TreeNode y;
    TreeNode pre;

    public void recoverTree(TreeNode root) {

        this.dfs(root);
        if (x != null && y != null) {
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        this.dfs(root.left);
        if (pre != null) {
            if (pre.val > root.val) y = root;
            if (x == null) x = pre;
        }
        pre = root;
        this.dfs(root.right);
    }
}
