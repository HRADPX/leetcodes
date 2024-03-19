package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-22
 */
public class SumEvenGrandparent_1315 {

    int sum;
    public int sumEvenGrandparent(TreeNode root) {

        if (root == null) return 0;
        this.dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode pp) {
        if (root == null) return;
        if (p != null && pp != null && (pp.val & 1) == 0) {
            sum += root.val;
        }
        pp = p;
        p = root;
        this.dfs(root.left, p, pp);
        this.dfs(root.right, p, pp);
    }
}
