package com.hr.list;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 */
public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(), p = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1 == null) p.next = list2;
        if (list2 == null) p.next = list1;
        return dummy.next;
    }
}
