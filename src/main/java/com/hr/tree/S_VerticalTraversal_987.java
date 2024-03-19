package com.hr.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class S_VerticalTraversal_987 {

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        Map<Integer, List<SortedNode>> map = new HashMap<>();
        this.traversal(root, map, 0, 1);
        for (int i = min; i <= max; i++) {
            List<SortedNode> list = map.get(i);
            Collections.sort(list);
            rs.add(list.stream().map(sn -> sn.val).collect(Collectors.toList()));
        }
        return rs;
    }

    private void traversal(TreeNode root, Map<Integer, List<SortedNode>> map, int vertical, int level) {
        if (root == null) return;
        min = Math.min(min, vertical);
        max = Math.max(max, vertical);
        map.computeIfAbsent(vertical, v -> new ArrayList<>()).add(new SortedNode(root.val, level));
        this.traversal(root.left, map, vertical - 1, level + 1);
        this.traversal(root.right, map, vertical + 1, level);
    }

    static class SortedNode implements Comparable<SortedNode> {
        int val;
        int level;

        SortedNode(int val, int level) {
            this.val = val;
            this.level = level;
        }

        @Override
        public int compareTo(SortedNode o) {
            int firstPriority = this.level - o.level;
            return firstPriority != 0 ? firstPriority : this.val - o.val;
        }
    }
}
