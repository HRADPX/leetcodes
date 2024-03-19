package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
