package com.hr.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 */
public class GenerateTrees_95 {

    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {

        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = dfs(start, i - 1);
            List<TreeNode> rights = this.dfs(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
