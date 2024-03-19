package com.hr.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-18
 * 栈方式实现
 */
public class S_BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        this.binaryTreePaths(root, "", res);
        return res;
    }

    private void binaryTreePaths(TreeNode root, String s, List<String> res) {
        if (root == null) return;
        s += root.val;
        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        } else {
            s += "->";
        }
        this.binaryTreePaths(root.left, s, res);
        this.binaryTreePaths(root.right, s, res);
    }


    public List<String> binaryTreePathsByStack(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<String> strings = new Stack<>();
        nodes.push(root);
        strings.push(String.valueOf(root.val));
        TreeNode node;
        String path;

        while(!nodes.isEmpty()){

            node = nodes.pop();
            path = strings.pop();
            if(node.left == null && node.right == null)
                res.add(path);
            if(node.right != null){
                nodes.push(node.right);
                strings.push(path + "->" + node.right.val);
            }
            if(node.left != null){
                nodes.push(node.left);
                strings.push(path + "->" + node.left.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        S_BinaryTreePaths_257 instance = ReflectUtils.getInstance(S_BinaryTreePaths_257.class);
        System.out.println(instance.binaryTreePathsByStack(root));
    }

}
