package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 *
 * 从叶子节点开始的最小字符串
 */
public class SmallestFromLeaf_988 {

    String rs;
    public String smallestFromLeaf(TreeNode root) {
        this.inorder(root, new StringBuilder());
        return rs;
    }

    private void inorder(TreeNode root, StringBuilder s) {
        if (root == null) return;
        s.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            s.reverse();
            String ss = s.toString();
            if (rs == null || ss.compareTo(rs) < 0) {
                rs = ss;
            }
            s.reverse();
        }
        this.inorder(root.left, s);
        this.inorder(root.right, s);
        s.deleteCharAt(s.length() - 1);
    }

    public static void main(String[] args) {

        System.out.println((char) ('a' + 1));
    }

}
