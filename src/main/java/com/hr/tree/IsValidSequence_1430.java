package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-28
 */
public class IsValidSequence_1430 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null && (arr == null || arr.length == 0)) return true;
        if (root == null || arr == null || arr.length == 0) return false;
        return this.dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode root, int[] arr, int i) {
        if (i == arr.length || root == null) return false;
        if (root.val != arr[i]) return false;
        if (i == arr.length - 1 && root.left == null && root.right == null) return true;
        return this.dfs(root.left, arr, i + 1) || this.dfs(root.right, arr, i + 1);
    }
}
