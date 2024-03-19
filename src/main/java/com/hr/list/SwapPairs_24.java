package com.hr.list;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-13
 */
public class SwapPairs_24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode p = head, pre = null, newHead = null;

        while (p != null && p.next != null) {
            ListNode next = p.next;
            ListNode nextStart = next.next;
            next.next = p;
            p.next = nextStart;
            if (pre != null) pre.next = next;
            pre = p;
            p = nextStart;
            if (newHead == null) newHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(2, 5, 3, 4, 6, 2, 2));
        SwapPairs_24 instance = ReflectUtils.getInstance(SwapPairs_24.class);
        System.out.println(ListNodeUtils.traversalList(instance.swapPairs(head)));
    }
}
