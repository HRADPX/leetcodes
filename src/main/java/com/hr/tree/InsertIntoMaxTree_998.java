package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class InsertIntoMaxTree_998 {

    // a = [2,1,5,4], b = [2,1,5,4,3]
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        root.right = this.insertIntoMaxTree(root.right, val);
        return root;
    }
}
