package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class R_Connect_117 {


    // 层序遍历省略...

    public Node connect(Node root) {

        Node node = root;
        // 使用一个占位节点
        Node dummy = new Node();
        Node p = dummy;

        while (node != null) {
            p.next = null;
            dummy = p;

            while (node != null) {
                if (node.left != null) {
                    dummy.next = node.left;
                    dummy = node.left;
                }
                if (node.right != null) {
                    dummy.next = node.right;
                    dummy = node.right;
                }
                node = node.next;
            }
            node = p.next;
        }
        return root;
    }
}
