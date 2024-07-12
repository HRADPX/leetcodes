package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 *
 * 二叉树与祖先节点的最大差值
 */
public class R_MaxAncestorDiff_1026 {

    int rs;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return rs;
    }

    // 记录每条路径的最大值和最小值
    public void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            rs = Math.max(rs, max - min);
            return;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
