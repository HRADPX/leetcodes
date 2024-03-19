package com.hr.path_sum;

import java.util.HashMap;

import com.hr.tree.TreeNode;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 */
public class R_PathSumIII_437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = this.rootSum(root, targetSum);
        res += this.pathSum(root.left, targetSum);
        res += this.pathSum(root.right, targetSum);
        return res;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == targetSum) res++;
        res += this.rootSum(root.left, targetSum - root.val);
        res += this.rootSum(root.right, targetSum - root.val);
        return res;
    }

    int res;
    public int pathSumV1(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        this.dfs(root, root.val, targetSum,  map);
        return res;
    }

    private void dfs(TreeNode root, long val, int targetSum, HashMap<Long, Integer> map) {
        if (map.containsKey(val - targetSum)) res += map.get(val - targetSum);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val, targetSum, map);
        if (root.right != null) dfs(root.right, val + root.right.val, targetSum, map);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }


    int ans;
    public int pathSumV2(TreeNode root, int sum) {
        if(root == null) return 0;
        int[] array = new int[1000];
        dfs(root,array,sum,0);
        return ans;
    }

    // 本质和前缀和类似
    private void dfs(TreeNode root,int[] array,int sum, int level){

        if(root == null) return;
        array[level] = root.val;
        int cur = 0;
        for (int i = level; i >= 0; i--) {
            cur += array[i];
            if(cur == sum) ++ans;
        }
        dfs(root.left,array,sum,level + 1);
        dfs(root.right,array,sum,level + 1);
    }
}
