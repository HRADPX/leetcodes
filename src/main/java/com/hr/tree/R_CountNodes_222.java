package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 *
 * 优化解法
 */
public class R_CountNodes_222 {

    // O(N)时间复杂度，没有用到完全二叉树的特征
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = this.countNodes(root.left);
        int right = this.countNodes(root.right);
        return left + right + 1;
    }

    // O(logN * logN)
    public int countNodes_1(TreeNode root) {
        TreeNode cur = root;
        int lc = 0, rc = 0;
        while (cur != null) {
            cur = cur.left;
            lc++;
        }
        cur = root;
        while (cur != null) {
            cur = cur.right;
            rc++;
        }
        if (lc == rc) return (1 << lc) - 1;
        return 1 + this.countNodes_1(root.left) + this.countNodes_1(root.right);
    }
}
