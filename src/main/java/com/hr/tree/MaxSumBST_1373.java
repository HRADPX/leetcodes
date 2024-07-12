package com.hr.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-26
 */
public class MaxSumBST_1373 {

    // 记录节点的和
    Map<TreeNode, Integer> sumMap = new HashMap<>();
    // 记录节点是否是 bst
    Map<TreeNode, Boolean> bstMap = new HashMap<>();
    public int maxSumBST(TreeNode root) {
        this.isBST(root);
        this.sum(root);
        this.dfs(root);
        return rs;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        treeNode = null;
        if (bstMap.get(root)) rs = Math.max(rs, this.sum(root));
        this.dfs(root.left);
        this.dfs(root.right);
    }

    private int sum(TreeNode root) {
        Integer sum = sumMap.get(root);
        if (sum != null) return sum;
        if (root == null) return 0;
        int left = this.sum(root.left);
        int right = this.sum(root.right);
        sumMap.put(root, root.val + left + right);
        return sumMap.get(root);
    }

    TreeNode treeNode;
    public boolean isBST(TreeNode root) {
        if (root == null) return true;
        boolean left = this.isBST(root.left);
        if (!left)
            return false;
        if (treeNode != null && treeNode.val >= root.val) return false;
        else treeNode = root;
        return this.isBST(root.right);
    }


    static class Solution {
        static final int INF = 0x3f3f3f3f;
        int res;

        class SubTree {
            boolean isBST;
            int minValue;
            int maxValue;
            int sumValue;

            SubTree(boolean isBST, int minValue, int maxValue, int sumValue) {
                this.isBST = isBST;
                this.minValue = minValue;
                this.maxValue = maxValue;
                this.sumValue = sumValue;
            }
        }

        public int maxSumBST(TreeNode root) {
            res = 0;
            dfs(root);
            return res;
        }

        public SubTree dfs(TreeNode root) {
            if (root == null) {
                return new SubTree(true, INF, -INF, 0);
            }
            SubTree left = dfs(root.left);
            SubTree right = dfs(root.right);

            if (left.isBST && right.isBST && root.val > left.maxValue && root.val < right.minValue) {
                int sum = root.val + left.sumValue + right.sumValue;
                res = Math.max(res, sum);
                return new SubTree(true, Math.min(left.minValue, root.val), Math.max(root.val, right.maxValue), sum);
            } else {
                return new SubTree(false, 0, 0, 0);
            }
        }
    }



    int rs;
    public int maxSumBSTV1(TreeNode root) {
        maxSumBst(root);
        return rs;
    }

    public Node maxSumBst(TreeNode root) {
        if (root == null) return new Node(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Node left = this.maxSumBst(root.left);
        Node right = this.maxSumBst(root.right);
        if (left.isBst && right.isBst && root.val > left.maxValue && root.val < right.minValue) {
            int sumValue = root.val + left.sumVal + right.sumVal;
            rs = Math.max(rs, sumValue);
            return new Node(true, sumValue, Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue));
        }
        return new Node(false, 0, 0, 0);
    }

    static class Node {
        boolean isBst;
        int sumVal;
        int minValue;
        int maxValue;
        public Node(boolean isBst, int sumVal, int minValue, int maxValue) {
            this.isBst = isBst;
            this.sumVal = sumVal;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
}
