package com.hr.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-20
 */
public class R_FlipMatchVoyage_971 {

    // 如果根节点，肯定无法翻转满足条件，然后判断左节点的值和下一个是否相同，
    // 如果相同递归，如果不同，交换左右子树顺序

    int index;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        List<Integer> rs = new ArrayList<>();
        this.traversal(root, rs, voyage);
        return rs;
    }

    private void traversal(TreeNode root, List<Integer> rs, int[] voyage) {

        if (root == null) return;
        if (rs.size() == 1 && rs.get(0) == -1) return;
        if (root.val != voyage[index++]) {
            rs.clear();
            rs.add(-1);
            return;
        }
        if (root.left != null && voyage[index] != root.left.val) {
            rs.add(root.val);
            this.traversal(root.right, rs, voyage);
            this.traversal(root.left, rs, voyage);
        } else {
            this.traversal(root.left, rs, voyage);
            this.traversal(root.right, rs, voyage);
        }
    }

//    public static void main(String[] args) {
//
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        R_FlipMatchVoyage_971 instance = ReflectUtils.getInstance(R_FlipMatchVoyage_971.class);
//        System.out.println(instance.flipMatchVoyage(root, new int[] {1, 3, 2}));
//    }


}
