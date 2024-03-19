package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class R_LowestCommonAncestor_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
