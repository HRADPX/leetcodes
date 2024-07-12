package com.hr.top100;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-28
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}