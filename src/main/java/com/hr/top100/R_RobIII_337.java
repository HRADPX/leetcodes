package com.hr.top100;

import java.util.Map;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-22
 */
public class R_RobIII_337 {

    public int rob(TreeNode root) {
        // if(root == null) return 0;
        // if(map.containsKey(root)) return map.get(root);
        // // 偷根节点
        // int rootVal = root.val;
        // if(root.left != null)
        //     rootVal += rob(root.left.left) + rob(root.left.right);
        // if(root.right != null)
        //     rootVal += rob(root.right.left) + rob(root.right.right);
        // // 不偷根节点
        // int noRootVal = rob(root.left) + rob(root.right);
        // int max = Math.max(rootVal,noRootVal);
        // map.put(root,max);
        // return max;
        /////////////////////动态规划////////////////////////////////////
        int[] result = dfs(root);
        return Math.max(result[0],result[1]);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        // 偷根节点
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += rob(root.left.left, map) + rob(root.left.right, map);
        }
        if (root.right != null) {
            sum1 += rob(root.right.left, map) + rob(root.right.right, map);
        }
        // 不偷根节点
        int sum2 = rob(root.left) + rob(root.right);
        int max = Math.max(sum1, sum2);
        map.put(root, max);
        return max;
    }

    /**
     * dp[0] 表示根节点的最大值，dp[1] 表示不偷根节点的最大值。
     */
    private int[] dfs(TreeNode root){

        if(root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // int rootVal = root.val + left[1] + right[1];
        // int noRootVal = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{root.val + left[1] + right[1], Math.max(left[0],left[1]) + Math.max(right[0],right[1])};

    }
}
