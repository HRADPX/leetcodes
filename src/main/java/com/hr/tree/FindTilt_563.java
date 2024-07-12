package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-29
 *
 * 二叉树的坡度
 */
public class FindTilt_563 {

    int rs;
    public int findTilt(TreeNode root) {
        this.dfs(root);
        return rs;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        int tilt = Math.abs(left - right);
        rs += tilt;
        return left + right + root.val;
    }


    static class Node {
        int tilt;
        int sum;

        Node() {}

        Node(int tilt, int sum) {
            this.tilt = tilt;
            this.sum = sum;
        }
    }

}
