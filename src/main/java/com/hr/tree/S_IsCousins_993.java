package com.hr.tree;

import java.util.LinkedList;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 *
 * 判断给定的两个值对应的节点是否是堂兄弟节点
 *
 * 思路1: 层序遍历，如果是堂兄弟节点，那一定是在同一层
 * 思路2: 遍历二叉树，找到 x 和 y，记录所在的层，判断是否在同一层
 */
public class S_IsCousins_993 {

    // 是否是堂兄弟节点

    // 层序遍历
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;
            boolean xx = false, yy = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    xx = true;
                }
                if (node.val == y) {
                    yy = true;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x || node.right.val == x) && (node.left.val == y || node.right.val == y)) {
                        return false;
                    }
                }
            }
            if (xx && yy && level > 2) {
                return true;
            }
            if (xx || yy) {
                return false;
            }
        }
        return false;
    }

    // 递归
    int xLevel = -1, yLevel = -2;
    boolean rs;
    boolean terminate;
    public boolean isCousinsV1(TreeNode root, int x, int y) {

        this.floor(root, 1, x, y);
        return rs;
    }

    private void floor(TreeNode root, int level, int x, int y) {

        if (rs || terminate) return;
        if (root == null) return;
        if (root.val == x) xLevel = level;
        if (root.val == y) yLevel = level;
        if (xLevel == yLevel && level > 2) {
            rs = true;
            return;
        }
        if (root.left != null && root.right != null) {
            if ((root.left.val == x || root.right.val == x) && (root.left.val == y || root.right.val == y)) {
                terminate = true;
                return;
            }
        }
        this.floor(root.left, level + 1, x, y);
        this.floor(root.right, level + 1, x, y);
    }
}
