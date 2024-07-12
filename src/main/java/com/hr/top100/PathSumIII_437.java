package com.hr.top100;

import java.util.Map;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-27
 */
public class PathSumIII_437 {

    // 还有两种解法
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 从当前节点开始...
        int res = rootSum(root, targetSum);
        // 从子节点开始...
        int left = this.pathSum(root.left, targetSum - root.val);
        int right = this.pathSum(root.right, targetSum - root.val);
        return res + left + right;
    }

    private int rootSum(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) return 0;
        if (targetSum == root.val) res = 1;
        int left = this.rootSum(root.left, targetSum - root.val);
        int right = this.rootSum(root.right, targetSum - root.val);
        return res + left + right;
    }


    private int rootSum(TreeNode root, int target, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        Integer count = map.get(root);
        if (count != null) return count;
        int res = 0;
        if (root.val == target) res = 0;
        int left = this.rootSum(root.left, target - root.val, map);
        int right = this.rootSum(root.right, target - root.val, map);

        res += left + right;
        map.put(root, res);
        return res;
    }
}
