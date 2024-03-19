package com.hr.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-13
 */
public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public ListNode reverseListV1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseListV1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
