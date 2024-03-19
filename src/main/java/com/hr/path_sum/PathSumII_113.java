package com.hr.path_sum;

import java.util.ArrayList;
import java.util.List;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 */
public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        this.dfs(root, rs, list, targetSum);
        return rs;
    }

    private void dfs(TreeNode root, List<List<Integer>> rs, List<Integer> list, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                rs.add(new ArrayList<>(list));
            }
            return;
        }
        this.dfs(root.left,  rs, list, targetSum - root.val);
        this.dfs(root.right, rs, list, targetSum - root.val);
        list.remove(list.size() - 1);
    }
}
