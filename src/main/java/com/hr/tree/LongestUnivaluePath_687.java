package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 */
public class LongestUnivaluePath_687 {

    int res;
    public int longestUnivaluePath(TreeNode root) {
        this.dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        if (root.left != null && root.left.val == root.val)
            left++;
        else
            left = 0;
        if (root.right != null && root.right.val == root.val)
            right++;
        else
            right = 0;
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }
}
