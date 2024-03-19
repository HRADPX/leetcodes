package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 */
public class FlipEquiv_951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        if ((root1.left != null && root2.left != null && root1.left.val == root2.left.val) || (root1.left == null && root2.left == null))
            return this.flipEquiv(root1.left, root2.left) && this.flipEquiv(root1.right, root2.right);
        return this.flipEquiv(root1.left, root2.right) && this.flipEquiv(root1.right, root2.left);
    }
}
