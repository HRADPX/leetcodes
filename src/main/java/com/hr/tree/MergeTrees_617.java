package com.hr.tree;

import java.util.LinkedList;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-01
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null
 * 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 */
public class MergeTrees_617 {

    // 不修改原数据结构
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);
        TreeNode left = this.mergeTrees(root1.left, root2.left);
        TreeNode right = this.mergeTrees(root1.right, root2.right);
        root.left = left;
        root.right = right;
        return root;
    }

    // 修改原数据结构
    public TreeNode mergeTreesV1(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTreesV1(t1.left,t2.left);
        t1.right = mergeTreesV1(t1.right,t2.right);
        return t1;
    }


    // 层序遍历
    public TreeNode mergeTreesV2(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);
        TreeNode node1, node2;

        while (!queue1.isEmpty()) {

            node1 = queue1.poll();
            node2 = queue2.poll();

            node1.val += node2.val;
            if(node1.left != null && node2.left != null){
                queue1.add(node1.left);
                queue2.add(node2.left);
            } else if(node1.left == null)
                node1.left = node2.left;
            if(node1.right != null && node2.right != null){
                queue1.add(node1.right);
                queue2.add(node2.right);
            } else if(node1.right == null)
                node1.right = node2.right;
        }
        return t1;
    }
}
