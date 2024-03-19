package com.hr.list;

import java.util.Stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-13
 */
public class AddTwoNumbers_445 {

    // 要求不翻转链表，使用栈实现
    // 但是需要额外空间，感觉没必要...
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> nums1 = new Stack<>();
        Stack<ListNode> nums2 = new Stack<>();
        while(l1 != null){
            nums1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null){
            nums2.push(l2);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode tail;
        while(!nums1.isEmpty() || !nums2.isEmpty()){

            int num1 = nums1.isEmpty() ? 0 : nums1.pop().val;
            int num2 = nums2.isEmpty() ? 0 : nums2.pop().val;
            int sum = num1 + num2 + carry;
            tail = new ListNode(sum % 10);
            carry = sum / 10;
            tail.next = dummy.next;
            dummy.next = tail;
        }
        if(carry > 0) {
            tail = new ListNode(1);
            tail.next = dummy.next;
            dummy.next = tail;
        }
        return dummy.next;
    }
}
