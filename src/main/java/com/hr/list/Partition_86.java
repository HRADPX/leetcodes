package com.hr.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 */
public class Partition_86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode min = new ListNode(), max = new ListNode();
        ListNode p = min, q = max, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur.next = null;
            cur = next;
        }
        p.next = max.next;
        return min.next;
    }
}
