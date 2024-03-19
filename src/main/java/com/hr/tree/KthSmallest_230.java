package com.hr.tree;

import java.util.Arrays;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-16
 */
public class KthSmallest_230 {

    int i, res;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        if (i > k) return;
        inorder(root.left, k);
        if (k == ++i) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }

    private void inorderV1(TreeNode root, int k) {
        if (root == null) return;
        if (i == k) return;
        inorderV1(root.left, k - 1);
        if (++i == k) {
            res = root.val;
            return;
        }
        inorderV1(root.right, k - 1);
    }


    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(TreeNodeUtils.preorderTraversal(root));
        System.out.println(TreeNodeUtils.inorderTraversal(root));
        KthSmallest_230 instance = ReflectUtils.getInstance(KthSmallest_230.class);
        System.out.println(instance.kthSmallest(root, 5));
    }

}
