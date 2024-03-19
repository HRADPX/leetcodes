package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 *
 * 给一个树的根节点，返回给定节点 p 和 q 的最近公共祖先(LCA)节点。
 * 如果p 或 q 之一不存在于该二叉树中,返回 null。 树中的每个节点值都是互不相同的。
 */
public class LowestCommonAncestorII_1644 {

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode rs = this.dfs(root, p, q);
        return pp != null && qq != null ? rs : null;
    }

    /**
     * 核心思路是判断是否相等的逻辑要放在后序位置，不能跟之前一样放前序位置，
     * 因为可能不存在，所以要遍历完整棵树
     */
    TreeNode pp, qq;
    public TreeNode dfs(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p) pp = root;
        if (root.val == q) qq = root;
        TreeNode left = this.dfs(root.left, p, q);
        TreeNode right = this.dfs(root.right, p, q);
        if(root.val == p || root.val == q) return root;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
