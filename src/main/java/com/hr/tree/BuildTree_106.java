package com.hr.tree;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-17
 *
 * 中序和后序还原二叉树
 */
public class BuildTree_106 {


    // inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {

        if (is > ie) {
            return null;
        }
        if (is == ie) {
            return new TreeNode(inorder[ie]);
        }
        TreeNode root = new TreeNode(postorder[pe]);
        // search root node index in inorder
        int rootIdx;
        for (rootIdx = is; rootIdx <= ie; rootIdx++) {
            if (inorder[rootIdx] == postorder[pe]) {
                break;
            }
        }

        TreeNode left = buildTree(inorder, is, rootIdx - 1, postorder, ps, ps + rootIdx - is - 1);
        TreeNode right = buildTree(inorder, rootIdx + 1, ie, postorder, ps + rootIdx - is, pe - 1);

        root.left = left;
        root.right = right;
        return root;
    }


    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = ReflectUtils.getInstance(BuildTree_106.class).buildTree(inorder, postorder);
        System.out.println(TreeNodeUtils.inorderTraversal(root));
        System.out.println(TreeNodeUtils.postOrderTraversal(root));
    }

}
