package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class CopyRandomList_138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            Node next = p.next;
            p.next = node;
            node.next = next;
            p = next;
        }
        // 处理随机指针
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        // 断开链表
        p = head;
        Node newHead = null;
        Node q = null;
        while (p != null) {
            if (q == null) {
                newHead = p.next;
                q = p.next;
            } else {
                q.next = p.next;
                q = q.next;
            }
            p.next = q.next;
            p = p.next;
            q.next = null;
        }
        return newHead;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node p = head;

        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }

        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
                p = p.next.next;
            }
        }
        Node newHead, q;
        newHead = q = null;
        p = head;
        // 断开...
        // 1->1->2->2->3->3
        while (p != null) {

            if (newHead == null) {
                newHead = p.next;
                q = newHead;
            } else {
                q.next = p.next;
                q = q.next;

            }
            p.next = q.next;
            p = p.next;
            q.next = null;

        }
        return newHead;
    }
}
