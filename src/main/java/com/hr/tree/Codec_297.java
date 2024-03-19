package com.hr.tree;

import java.util.Arrays;
import java.util.Stack;

import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-01-19
 */
public class Codec_297 {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    int index;
    public TreeNode deserialize(String serialized) {
        if (serialized == null || serialized.length() < 4) {
            return null;
        }
        String[] nodes = serialized.split(",");
        return this.deserializeV1(nodes);
    }

    private TreeNode deserialize(String[] nodes) {
        if (nodes[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = this.deserialize(nodes);
        root.right = this.deserialize(nodes);

        return root;
    }


    public TreeNode deserializeV1(String[] nodes) {

        if (nodes == null || nodes.length < 4) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        stack.push(root);

        // 4,2,1,#,#,3,#,#,6,5,#,#,7,#,#,
        int index = 1;
        while (index < nodes.length && !nodes[index].equals("#")) {
            TreeNode left = new TreeNode(Integer.parseInt(nodes[index]));
            stack.peek().left = left;
            stack.push(left);
            index++;
        }
        // 4, 2, 1
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // 左子树肯定为空，直接跳过判断右子树
            if(++index < nodes.length && !nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index++]));
                stack.push(node.right);

                while (index < nodes.length && !nodes[index].equals("#")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index++]));
                    stack.peek().left = leftNode;
                    stack.push(leftNode);
                }
            }

        }
        return root;
    }



    public static void main(String[] args) {

        TreeNode root = TreeNodeUtils.buildBalanceTreeByList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Codec_297 instance = ReflectUtils.getInstance(Codec_297.class);
        String serialize = instance.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = instance.deserialize(serialize);
        System.out.println(TreeNodeUtils.preorderTraversal(deserialize));
        System.out.println(TreeNodeUtils.inorderTraversal(deserialize));
    }
}
