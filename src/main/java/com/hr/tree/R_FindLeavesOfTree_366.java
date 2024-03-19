package com.hr.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class R_FindLeavesOfTree_366 {

    Set<TreeNode> nodes = new HashSet<>();

    public List<List<Integer>> findLeavesOfTree(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        this.dfs(root, res);
        return res;
    }

    private int dfs(TreeNode root, List<List<Integer>> rs) {
        if (root == null) return 0;
        int left = dfs(root.left, rs);
        int right = dfs(root.right, rs);
        int deep = Math.max(left, right) + 1;
        if (rs.size() < deep) {
            rs.add(deep - 1, new ArrayList<>());
        }
        rs.get(deep - 1).add(root.val);
        return deep;
    }
}
