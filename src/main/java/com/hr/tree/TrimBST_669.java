package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * 修剪树 不应该 改变保留在树中的元素的相对结构
 * (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变
 */
public class TrimBST_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return this.trimBST(root.right, low, high);
        if (root.val > high) return this.trimBST(root.left, low, high);
        root.left = this.trimBST(root.left, low, high);
        root.right = this.trimBST(root.right, low, high);
        return root;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return this.trimBST2(root.left, low, high);
        if (root.val < low) return this.trimBST2(root.right, low, high);
        root.left = this.trimBST2(root.left, low, high);
        root.right = this.trimBST2(root.right, low, high);
        return root;
    }
}
