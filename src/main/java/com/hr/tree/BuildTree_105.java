package com.hr.tree;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-17
 *
 * 前序和中序遍历还原二叉树
 */
public class BuildTree_105 {

    // preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7}
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

        if (ps > pe) {
            return null;
        }
        if (ps == pe) {
            return new TreeNode(preorder[ps]);
        }
        TreeNode root = new TreeNode(preorder[ps]);
        // search root node index in inorder
        int rootIdx = is;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) {
                rootIdx = i;
                break;
            }
        }
        TreeNode left = this.buildTree(preorder, ps + 1, ps + rootIdx - is, inorder, is, rootIdx - 1);
        TreeNode right = this.buildTree(preorder, ps + 1 + rootIdx - is, pe, inorder, rootIdx + 1, ie);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};


        TreeNode root = ReflectUtils.getInstance(BuildTree_105.class).buildTree(preorder, inorder);
        System.out.println(TreeNodeUtils.preorderTraversal(root));
        System.out.println(TreeNodeUtils.inorderTraversal(root));
    }
}
