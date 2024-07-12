package com.hr.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 *
 * 给你一棵二叉树的根节点 root ，返回所有重复的子树
 */
public class R_FindDuplicateSubtrees_652 {

    // 计算以每个节点作为根节点的序列化后的值
    private Map<String, Integer> nodeMap = new HashMap<>();
    private Set<TreeNode> rs = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(rs);
    }

    private String dfs(TreeNode root) {
        if (root == null) return "";
        String key = root.val + dfs(root.left) + "_" + dfs(root.right);

        if (nodeMap.getOrDefault(key, 0) == 1) {
            rs.add(root);
        }
        nodeMap.put(key, nodeMap.getOrDefault(key, 0) + 1);
        return key;
    }
}
