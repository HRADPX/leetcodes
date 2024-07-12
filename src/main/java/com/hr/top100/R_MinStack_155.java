package com.hr.top100;

import java.util.Stack;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-28
 */
public class R_MinStack_155 {

    // MinStack() 初始化堆栈对象。
    //void push(int val) 将元素val推入堆栈。
    //void pop() 删除堆栈顶部的元素。
    //int top() 获取堆栈顶部的元素。
    //int getMin() 获取堆栈中的最小元素。

    private Stack<Integer> p;
    private int min;

    public R_MinStack_155() {
        p = new Stack<>();
    }

    public void push(int val) {
        if (p.isEmpty() || val <= min) {
            p.push(min);
            p.push(val);
            min = val;
        } else
            p.push(val);
    }

    public void pop() {
        if (p.isEmpty()) return;
        if (p.pop() == min) {
            min = p.pop();
        }
    }

    public int top() {
        return p.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {

        R_MinStack_155 instance = new R_MinStack_155();
        instance.push(4);
        instance.push(5);
        instance.push(6);
        instance.push(3);
        instance.push(4);
        instance.pop();
        System.out.println(instance.getMin());
        instance.pop();
        System.out.println(instance.getMin());
        instance.pop();
        System.out.println(instance.getMin());

    }
}
