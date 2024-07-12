package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-01
 *
 * 没想到最优解法
 *
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 */
public class SS_FindSecondMinimumValue_671 {

    Integer rs;
    public int findSecondMinimumValueV1(TreeNode root) {
        this.dfs(root, root.val);
        return rs == Integer.MAX_VALUE ? -1 : rs;
    }

    // 找到就可以提前终止
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null && root.right == null) return -1;
        int left = root.left.val, right = root.right.val;
        if (left == root.val) left = findSecondMinimumValue(root.left);
        if (right == root.val) right = findSecondMinimumValue(root.right);
        if (left == -1 || right == -1) return left + right + 1;
        return Math.min(left,right);
    }

    private void dfs(TreeNode root, int min) {
        if (root == null) return;
        if (root.val > min) {
            rs = rs == null ? root.val : Math.min(rs, root.val);
            return;
        }
        this.dfs(root.left, min);
        this.dfs(root.right, min);
    }
}
