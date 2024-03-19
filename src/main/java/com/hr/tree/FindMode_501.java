package com.hr.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class FindMode_501 {

    Map<Integer, Integer> countMap = new HashMap<>();
    int maxCount;
    public int[] findMode(TreeNode root) {

        this.dfs(root);
        List<Integer> rs = new ArrayList<>();
        for (Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                rs.add(entry.getKey());
            }
        }
        int[] res = new int[rs.size()];
        for (int i = 0; i < rs.size(); i++) {
            res[i] = rs.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        dfs(root.left);
        int count = countMap.getOrDefault(root.val, 0) + 1;
        countMap.put(root.val, count);
        maxCount = Math.max(maxCount, count);
        dfs(root.right);
    }

    public int[] findModeV1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.traversal(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }

    TreeNode node;
    int count;
    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        this.traversal(root.left, list);
        if (node != null && node.val == root.val)
            count++;
        else
            count = 1;  // reset count for a new value
        if (count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            list.add(root.val);
        }
        node = root;
        this.traversal(root.right, list);
    }





}
