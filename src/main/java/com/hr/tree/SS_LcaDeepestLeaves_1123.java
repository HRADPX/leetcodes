package com.hr.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 */
public class SS_LcaDeepestLeaves_1123 {

    TreeNode rs;

    /**
     * 遍历一遍
     */
    int maxDepth = -1;
    public TreeNode lcaDeepestLeavesV1(TreeNode root) {
        dfsV1(root, 0);
        return rs;
    }


    private int dfsV1(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth - 1);
            return depth - 1;
        }
        int left = dfsV1(node.left, depth + 1);
        int right = dfsV1(node.right, depth + 1);
        // 后序遍历
        if(left == right && left == maxDepth) rs = node;
        return Math.max(left, right);
    }


    /**
     * 遍历两遍
     */
    Map<TreeNode, Integer> depthMap = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = this.depth(root);
        this.dfs(root, depth);
        return rs;
    }

    private void dfs(TreeNode root, int depth) {
        if (rs != null) return;
        if (root == null) return;
        Integer ld = depthMap.get(root.left);
        Integer rd = depthMap.get(root.right);
        if (ld == depth - 1 && rd == depth - 1) {
            rs = root;
            return;
        }
        this.dfs(root.left, depth - 1);
        this.dfs(root.right, depth - 1);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            depthMap.putIfAbsent(null, 0);
            return 0;
        }
        int left = this.depth(root.left);
        int right = this.depth(root.right);
        this.depthMap.put(root, Math.max(left, right) + 1);
        return this.depthMap.get(root);
    }
}
