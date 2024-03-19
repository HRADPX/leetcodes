package com.hr.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class FindFrequentTreeSum_508 {

    private int maxCount;
    private Map<Integer, Integer> sumMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        this.dfs(root);

        List<Integer> res = new ArrayList<>();
        for (Entry<Integer, Integer> entry : sumMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                res.add(entry.getKey());
            }
        }
        int[] rs = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            rs[i] = res.get(i);
        }
        return rs;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = this.dfs(root.left);
        int right = this.dfs(root.right);
        root.val += (left + right);
        int count = sumMap.getOrDefault(root.val, 0) + 1;
        sumMap.put(root.val, count);
        maxCount = Math.max(maxCount, count);
        return root.val;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);

        FindFrequentTreeSum_508 instance = ReflectUtils.getInstance(FindFrequentTreeSum_508.class);
        System.out.println(Arrays.toString(instance.findFrequentTreeSum(root)));

    }

}
