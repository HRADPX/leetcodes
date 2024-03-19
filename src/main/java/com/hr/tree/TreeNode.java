package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-16
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + "}";
    }
}

