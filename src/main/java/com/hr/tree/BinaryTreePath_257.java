package com.hr.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-29
 */
public class BinaryTreePath_257 {

    public List<String> binaryTreePath(TreeNode root) {
        List<String> res = new ArrayList<>();
        this.dfs(root, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list, List<String> res) {
        if (root == null) return;
        if(root.left == null && root.right == null){
            StringBuilder ss = new StringBuilder();
            for (Integer i : list)
                ss.append(i).append("->");
            res.add(ss.append(root.val).toString());
        }
        list.add(root.val);
        dfs(root.left,list,res);
        dfs(root.right,list,res);
        list.remove(list.size() - 1);
    }
}
