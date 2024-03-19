package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int right = minDepth(root.right);
        int left = minDepth(root.left);

        return Math.min(left, right) + 1;
    }
}
