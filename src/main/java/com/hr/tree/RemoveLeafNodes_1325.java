package com.hr.tree;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-22
 */
public class RemoveLeafNodes_1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.dfs(root, null, target);
        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }

    private void dfs(TreeNode root, TreeNode p, int target) {
        if (root == null) return;
        dfs(root.left, root, target);
        dfs(root.right, root, target);
        if (root.left == null && root.right == null && root.val == target) {
            if (p != null && p.left == root) p.left = null;
            if (p != null && p.right == root) p.right = null;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);

        RemoveLeafNodes_1325 instance = ReflectUtils.getInstance(RemoveLeafNodes_1325.class);
        System.out.println(TreeNodeUtils.inorderTraversal(instance.removeLeafNodes(root, 2)));
    }
}
