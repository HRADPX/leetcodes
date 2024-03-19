package com.hr.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head.next, slow = head;

        while (fast != slow) {
            if (fast.next == null) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
