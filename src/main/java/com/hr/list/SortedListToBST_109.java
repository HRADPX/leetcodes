package com.hr.list;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-08
 *
 * 给定一个单链表的头节点  head ，其中的元素按升序排序 ，将其转换为平衡二叉搜索树。
 */
public class SortedListToBST_109 {

    // 引入占位节点，但是不是必要
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rootNode = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(rootNode.val);
        root.left = this.sortedListToBST(dummy.next);
        root.right = this.sortedListToBST(rootNode.next);
        return root;
    }

    public TreeNode sortedListToBSTV1(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode rootNode = findMiddleNode(head);
        TreeNode root = new TreeNode(rootNode.val);
        root.left = sortedListToBSTV1(head);
        root.right = sortedListToBSTV1(rootNode.next);
        return root;
    }

    private ListNode findMiddleNode(ListNode head) {

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) pre.next = null;// 将链表一分为二

        return slow;
    }
}
