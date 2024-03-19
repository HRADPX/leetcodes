package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-22
 */
public class S_MaxProduct_1339 {

    int MOD_VALUE = 1000000000 + 7;
    long rs;
    public int maxProduct(TreeNode root) {
        this.dfs(root);
        this.traversal(root, root.val);
        return (int) (rs % MOD_VALUE);
    }

    private void traversal(TreeNode root, long sum) {
        if (root == null) return;
        rs = Math.max(rs, root.val * (sum - root.val));
        this.traversal(root.left, sum);
        this.traversal(root.right, sum);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        root.val += left + right;
        return root.val;
    }
}
