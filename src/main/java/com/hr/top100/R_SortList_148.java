package com.hr.top100;

import com.hr.list.ListNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class R_SortList_148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow, fast;
        slow = head; fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;

        return this.mergeList(this.sortList(head), this.sortList(tail));
    }

    private ListNode mergeList(ListNode h1, ListNode h2) {

        if (h1 == null) return h2;
        if (h2 == null) return h1;
        ListNode p, dummy, l1, l2;
        dummy = p = new ListNode();
        l1 = h1; l2 = h2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }
}
