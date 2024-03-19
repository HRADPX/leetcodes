package com.hr.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-19
 *
 * 二叉树的最大宽度
 */
public class Connect_116 {

    // 层序
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = null;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Node node = queue.poll();

                if (cur != null) {
                    cur.next = node;
                }
                cur = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    // 递归
    public Node connectV1(Node root) {
        this.dfs(root);
        return root;
    }

    private void dfs(Node root) {
        if (root == null || root.left == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }


    public Node connect3(Node root) {

        Node mostLeft = root;

        while (mostLeft != null) {
            Node node = mostLeft;
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }
                if (node.next != null && node.next.left != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            mostLeft = mostLeft.left;
        }
        return root;
    }




    // 迭代
    public Node connect2(Node root) {
        Node mostLeft = root;
        while (mostLeft != null) {

            Node node = mostLeft;
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }
                if (node.next != null && node.right != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            mostLeft = mostLeft.left;
        }
        return root;
    }

}
