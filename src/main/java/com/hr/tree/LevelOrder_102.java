package com.hr.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 *
 * 二叉树的层序遍历
 */
public class LevelOrder_102 {

    /**
     * 迭代实现
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 当前层节点的数量
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            rs.add(list);
        }
        return rs;
    }

    /**
     * 递归版
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> rs = new LinkedList<>();
        this.traversal(root, rs, 1);
        return rs;
    }

    private void traversal(TreeNode root, LinkedList<List<Integer>> rs, int depth) {

        if (root == null) return;

        if (rs.size() < depth) {
            rs.addLast(new ArrayList<>());
        }
        rs.get(depth - 1).add(root.val);
        traversal(root.left, rs, depth + 1);
        traversal(root.right, rs, depth + 1);
    }

    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(ReflectUtils.getInstance(LevelOrder_102.class).levelOrder(root));
    }
}
