package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 *
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示
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
