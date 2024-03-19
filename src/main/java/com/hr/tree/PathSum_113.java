package com.hr.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-21
 */
public class PathSum_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        this.dfs(root, 0, rs, list, targetSum);
        return rs;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> rs, List<Integer> list, int targetSum) {

        if (root == null) return;
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            rs.add(new ArrayList<>(list));
        }
        this.dfs(root.left, sum, rs, list, targetSum);
        this.dfs(root.right, sum, rs, list, targetSum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1,2,3,4,5,6,7));
//        System.out.println(TreeNodeUtils.preorderTraversal(root));
//        System.out.println(TreeNodeUtils.inorderTraversal(root));

        PathSum_113 instance = ReflectUtils.getInstance(PathSum_113.class);
        instance.pathSum(root, 10);
    }
}
