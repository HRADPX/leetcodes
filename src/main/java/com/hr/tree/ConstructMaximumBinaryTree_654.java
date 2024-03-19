package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-18
 */
public class ConstructMaximumBinaryTree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(nums[low]);
        }

        int rootIdx = low;

        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > nums[rootIdx]) {
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[rootIdx]);
        root.left = constructMaximumBinaryTree(nums, low, rootIdx - 1);
        root.right = constructMaximumBinaryTree(nums, rootIdx + 1, high);
        return root;
    }
}
