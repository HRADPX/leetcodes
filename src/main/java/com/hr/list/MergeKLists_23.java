package com.hr.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 */
public class MergeKLists_23 {

    // 递归，不需要额外空间
    // 算法复杂度: O(NlogK)
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start > end) return null;
        if (start == end) return lists[start];
        int mid = (start + end) >>> 1;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return this.merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode dummy = new ListNode(), p = dummy;

        while (left != null && right != null) {

            if (left.val > right.val) {
                p.next = new ListNode(right.val);
                right = right.next;
            } else {
                p.next = new ListNode(left.val);
                left = left.next;
            }
            p = p.next;
        }
        if (left == null) p.next = right;
        if (right == null) p.next = left;
        return dummy.next;
    }

    /**
     * 借助小顶堆
     * 算法时间复杂度: O(NlogK)
     */
    public ListNode mergeKListV1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode();
        ListNode p = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) queue.add(node.next);
            p = p.next;
        }
        return dummy.next;
    }


}
