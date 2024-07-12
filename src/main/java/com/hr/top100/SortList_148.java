package com.hr.top100;

import com.hr.list.ListNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-31
 */
public class SortList_148 {

    // 分治
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;
        // 计算链表长度
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, h1, h2;


        while (index < len) {

            cur = dummy.next;
            p = dummy;
            while (cur != null) {
                int i = index, j = index;
                h1 = cur;
                while (i > 0 && cur != null) {
                    cur = cur.next;
                    --i;
                }
                if (cur == null)
                    break;
                h2 = cur;
                while (j > 0 && cur != null) {
                    cur = cur.next;
                    --j;
                }
                i = index;
                j = index - j;
                while (i > 0 && j > 0) {

                    if (h1.val < h2.val) {
                        p.next = h1;
                        h1 = h1.next;
                        --i;
                    } else {
                        p.next = h2;
                        h2 = h2.next;
                        --j;
                    }
                    p = p.next;
                }
                while (i > 0) {
                    p.next = h1;
                    h1 = h1.next;
                    p = p.next;
                    --i;
                }
                while (j > 0) {
                    p.next = h2;
                    h2 = h2.next;
                    p = p.next;
                    --j;
                }
                p.next = cur;
            }
            index *= 2;
        }
        return dummy.next;
    }
}
