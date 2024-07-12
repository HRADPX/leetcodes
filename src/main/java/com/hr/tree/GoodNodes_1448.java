package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-28
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
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
