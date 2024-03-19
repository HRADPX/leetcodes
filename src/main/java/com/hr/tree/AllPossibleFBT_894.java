package com.hr.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-04
 */
public class AllPossibleFBT_894 {

    /**
     * 使用内存优化
     */
    Map<Integer, List<TreeNode>> memory = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if (!memory.containsKey(n)) {
            if ((n & 1) == 0) return Collections.emptyList();
            if (n == 1) return Collections.singletonList(new TreeNode());
            List<TreeNode> rs = new ArrayList<>();
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> lefts = this.allPossibleFBT(i);
                List<TreeNode> rights = this.allPossibleFBT(n - i - 1);
                for (TreeNode leftTree : lefts) {
                    for (TreeNode rightTree : rights) {
                        TreeNode root = new TreeNode();
                        root.left = leftTree;
                        root.right = rightTree;
                        rs.add(root);
                    }
                }
            }
            memory.put(n, rs);
        }
        return memory.get(n);
    }

    public List<TreeNode> allPossibleFBTV1(int n) {

        if ((n & 1) == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(new TreeNode());
        List<TreeNode> rs = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> lefts = this.allPossibleFBTV1(i);
            List<TreeNode> rights = this.allPossibleFBTV1(n - i - 1);
            for (TreeNode leftTree : lefts) {
                for (TreeNode rightTree : rights) {
                    TreeNode root = new TreeNode();
                    root.left = leftTree;
                    root.right = rightTree;
                    rs.add(root);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {

        AllPossibleFBT_894 instance = ReflectUtils.getInstance(AllPossibleFBT_894.class);
        List<TreeNode> treeNodes = instance.allPossibleFBT(7);
        for (TreeNode node : treeNodes) {
            System.out.println(node);
        }

    }
}
