package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 */
public class SearchBST_700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) return this.searchBST(root.left, val);
        if (root.val < val) return this.searchBST(root.right, val);
        return root;
    }
}
