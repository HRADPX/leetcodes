package com.hr.top100;

import com.hr.list.ListNode;
import com.hr.list.ListNodeUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class ReverseKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k <= 1) return head;

        ListNode p = head; int i = 0;
        // 1->2->3 ->4
        while (p != null && i < k - 1) {
            p = p.next;
            i++;
        }
        if (p == null) return head;
        ListNode nextHead = p.next;
        // 3->2->1
        ListNode newHead = reverse(head, nextHead);
        head.next = reverseKGroup(nextHead, k);
        return newHead;
}

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode p = start, pre = null;
        while (p != end) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(1, 2, 3);
        System.out.println(
                ListNodeUtils.traversalList(ReflectUtils.getInstance(ReverseKGroup_25.class).reverseKGroup(head, 3)));
    }
}
