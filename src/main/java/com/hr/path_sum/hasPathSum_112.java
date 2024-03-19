package com.hr.path_sum;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 */
public class hasPathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) return true;
        return this.hasPathSum(root.left, targetSum - root.val) || this.hasPathSum(root.right, targetSum - root.val);
    }
}
