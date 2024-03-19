package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-06-16
 */
public class MaxPathSum_124 {

   int max = Integer.MIN_VALUE;
   public int maxPathSum(TreeNode root) {
       postTraversal(root);
       return max;
   }

    private int postTraversal(TreeNode root) {
       if (root == null) {
           return 0;
       }
       int left = postTraversal(root.left);
       int right = postTraversal(root.right);
       
       this.max = Math.max(max, left + right + root.val);
       return Math.max(0, root.val + Math.max(left, right));
    }
}