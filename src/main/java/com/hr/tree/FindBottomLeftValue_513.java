package com.hr.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class FindBottomLeftValue_513 {

    int layer;
    Map<Integer, Integer> nodeMap = new HashMap<>();

    public int findBottomLeftValue(TreeNode root) {

        this.traversal(root, 1);
        return nodeMap.get(layer);
    }

    private void traversal(TreeNode root, int level) {

        if (root == null) return;
        this.traversal(root.left, level + 1);
        nodeMap.putIfAbsent(level, root.val);
        layer = Math.max(layer, level);
        this.traversal(root.right, level + 1);
    }

    int rs;
    private void traversalV1(TreeNode root, int level) {

        if (root == null) return;
        this.traversal(root.left, level + 1);
        if (level > layer) {
            layer = level;
            rs = root.val;
        }
        this.traversal(root.right, level + 1);
    }
}
