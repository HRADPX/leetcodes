package com.hr.tree;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-03-06
 */
public class DeleteNode_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key)
            root.left = this.deleteNode(root.left, key);

        else if (root.val < key)
            root.right = this.deleteNode(root.right, key);

        else  {
            // 用要删除节点的右节点替换删除的节点，只要将要删除节点的左子树看作一个整体，迁移到右子树左叶子节点上，这样实现上简单点
            if (root.left == null) return root.right;
            if (root.right == null)  return root.left;
            TreeNode node = root.right;
            while (node.left != null)                   // 寻找欲删除节点右子树的最左叶子节点
                node = node.left;

            node.left = root.left;                      // 将欲删除节点的左子树成为其右子树的最左节点的左子树
            root = root.right;                          // 欲删除节点的右子顶替其位置，节点被删除
        }
//        else {
            // 找到要删除的节点，替换节点为右子树的左叶子节点，删除节点的右子树不动
//            if (root.right == null) return root.left;
//            if (root.left == null) return root.right;
//            TreeNode p = root.right;
//            TreeNode pp = p;
//            while (p.left != null) {
//                pp = p;
//                p = p.left;
//            }
//            if (pp == root) {
//                root.val = p.val;
//                root.right = p.right;
//            } else {
//                pp.left = p.right;
//                root.val = p.val;
//            }
//        }
        return root;
    }
}
