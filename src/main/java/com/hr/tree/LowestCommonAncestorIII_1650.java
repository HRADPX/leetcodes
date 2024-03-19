package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 * 给两个树的节点，每个节点都保存父节点，找到这两个节点的最近公共祖先节点
 *
 * 思路和找两个链路的公共节点一致
 */
public class LowestCommonAncestorIII_1650 {

    public Node lowestCommonAncestorIII(Node p, Node q) {
        Node pp = p, qq = q;
        while (pp != qq) {
            pp = pp == null ? q : pp.parent;
            qq = qq == null ? p : qq.parent;
        }
        return pp;
    }

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    public static void main(String[] args) {


    }
}
