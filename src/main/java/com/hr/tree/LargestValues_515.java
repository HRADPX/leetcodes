package com.hr.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-19
 */
public class LargestValues_515 {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> rs = new ArrayList<>();
        if (root == null) return rs;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            rs.add(max);
        }
        return rs;
    }
}
