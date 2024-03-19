package com.hr.tree;

import java.util.Arrays;
import java.util.List;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-07
 *
 * 给一个树的根节点和一个树的节点数组，找到这个数组中所有节点的最近公共祖先节点，树中每个节点的值都不同。
 *
 * 思路1:先序遍历，如果发现当前节点在列表里，直接返回，因为后续的节点都是当前节点的子节点。判断左右子树的情况，同 236 题。
 * 思路2:从根节点向下遍历，计算当前子树命中目标节点的数目，而其中最深的且命中所有目标节点的子树就是最终答案。
 */
public class LowestCommonAncestorIV_1676 {

    public TreeNode lowestCommonAncestorIV(TreeNode root, List<TreeNode> nodes) {
        if (nodes == null || nodes.isEmpty()) return null;
        if (nodes.size() == 1) return nodes.get(0);
        return this.dfs(root, nodes);
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) return root;
        TreeNode left = this.dfs(root.left, nodes);
        TreeNode right = this.dfs(root.right, nodes);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    /**
     * 树中各个元素都不相同
     */
    TreeNode rs;
    private int preorder(TreeNode root, List<Integer> nodes) {

        if (root == null) return 0;

        int left = this.preorder(root.left, nodes);
        int right = this.preorder(root.right, nodes);

        int cnt = left + right;
        if (nodes.contains(root.val)) cnt += 1;
        if (cnt == nodes.size() && rs == null)
            rs = root;

        return cnt;
    }

    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        LowestCommonAncestorIV_1676 instance = ReflectUtils.getInstance(LowestCommonAncestorIV_1676.class);
        instance.preorder(root, Arrays.asList(1,2,3));
        System.out.println(instance.rs.val);
    }
}
