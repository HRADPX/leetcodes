package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-01
 */
public class R_LongestUnivaluePath_687 {

    int rs;
    public int longestUnivaluePath(TreeNode root) {
        this.dfs(root);
        return rs;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        if (root.left != null && root.val == root.left.val)
            left += 1;
        else
            left = 0;
        if (root.right != null && root.val == root.right.val)
            right += 1;
        else
            right = 0;
        rs = Math.max(rs, left + right);
        return Math.max(left, right);
    }

    private int dfsV1(TreeNode root) {
        if(root == null) return 0;
        int left = this.dfsV1(root.left);
        int right = this.dfsV1(root.right);
        if(root.left != null && root.val != root.left.val) left = 0;
        if(root.right != null && root.val != root.right.val) right = 0;
        rs = Math.max(left + right, rs);
        return Math.max(left,right) + 1;
        // if(root.left != null && root.right != null && root.left.val == root.val && root.val == root.right.val)
        //     ans = Math.max(left + right, ans);
        // else if(root.left != null && root.val == root.left.val)
        //     ans = Math.max(left, ans);
        // else if(root.right != null && root.right.val == root.val)
        //     ans = Math.max(right, ans);
        // return Math.max(left,right) + 1;
    }


}
