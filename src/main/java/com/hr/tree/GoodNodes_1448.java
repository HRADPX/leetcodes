package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-28
 */
public class GoodNodes_1448 {

    int rs;
    public int goodNodes(TreeNode root) {
        this.dfs(root, root.val);
        return rs;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            rs++;
            max = Math.max(max, root.val);
        }
        this.dfs(root.left, max);
        this.dfs(root.right, max);
    }
}
