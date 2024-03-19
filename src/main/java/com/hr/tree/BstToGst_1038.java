package com.hr.tree;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-17
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 */
public class BstToGst_1038 {

    int val;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        root.val += val;
        val = root.val;
        dfs(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3));
        TreeNode treeNode = ReflectUtils.getInstance(BstToGst_1038.class).bstToGst(root);
        System.out.println(TreeNodeUtils.inorderTraversal(treeNode));
    }
}
