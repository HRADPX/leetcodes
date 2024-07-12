package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-26
 *
 * 和 1273 题相似
 */
public class SS_LongestZigZag_1372 {

    int rs;
    public int longestZigZag(TreeNode root) {
        this.dfs(root);
        return rs;
    }

    // 后序遍历
    private Result dfs(TreeNode root) {
        if (root == null) return null;
        Result left = this.dfs(root.left);
        Result right = this.dfs(root.right);
        // leave root node
        int lv = 0, rv = 0;
        if (left != null) {
            rs = Math.max(rs, Math.max(left.right + 1, left.left));
            lv = left.right + 1;
        }
        if (right != null) {
            rs = Math.max(rs, Math.max(right.left + 1, right.right));
            rv = right.left + 1;
        }
        return new Result(lv, rv);
    }

    static class Result {
        int left;
        int right;
        Result(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
