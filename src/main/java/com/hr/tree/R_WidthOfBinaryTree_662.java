package com.hr.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class R_WidthOfBinaryTree_662 {

    int ans;
    public int widthOfBinaryTreeV1(TreeNode root) {

        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        this.dfs(root, map, 1, 1);
        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, int level, int num) {

        if (root == null) return;
        // 存当前层第一个节点的序号
        map.putIfAbsent(level, num);
        ans = Math.max(ans, num - map.get(level) + 1);
        this.dfs(root.left, map, level + 1, num * 2);
        this.dfs(root.right, map, level + 1, num * 2 + 1);
    }

    private int dfsV1(TreeNode root, Map<Integer, Integer> map, int level, int num) {
        if (root == null) return 0;
        // 存当前层第一个节点的序号
        map.putIfAbsent(level, num);
        int result = num - map.get(level) + 1;
        int left = this.dfsV1(root.left, map, level + 1, num * 2);
        int right = this.dfsV1(root.right, map, level + 1, num * 2 + 1);
        return Math.max(result, Math.max(left, right));
    }

    // 层序遍历
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        this.traversal(root, 1);

        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = Math.max(ans, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }

    // 重新编号
    private void traversal(TreeNode root, int num) {
        if (root == null) return;
        root.val = num;
        this.traversal(root.left, num * 2);
        this.traversal(root.right, num * 2 + 1);
    }
}