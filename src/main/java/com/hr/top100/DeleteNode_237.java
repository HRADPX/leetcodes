package com.hr.top100;

import com.hr.list.ListNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-26
 */
public class DeleteNode_237 {

    // 无法访问头节点删除指定节点
    // 所有的节点的值都是唯一的  --> 这个条件没用上
    // 要删除的节点不在末尾
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
