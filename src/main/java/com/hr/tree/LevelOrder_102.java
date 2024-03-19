package com.hr.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> rs = new LinkedList<>();
        this.traversal(root, rs, 1);
        return rs;
    }

    private void traversal(TreeNode root, LinkedList<List<Integer>> rs, int depth) {

        if (root == null) return;

        if (rs.size() < depth) {
            rs.addFirst(new ArrayList<>());
        }
        traversal(root.left, rs, depth + 1);
        traversal(root.right, rs, depth + 1);
        rs.get(rs.size() - depth).add(root.val);
    }
}
