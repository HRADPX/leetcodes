package com.hr.tree;

import java.util.Arrays;

import com.hr.list.ListNode;
import com.hr.list.ListNodeUtils;
import com.hr.utils.ReflectUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-02-23
 */
public class R_IsSubPath_1367 {

    public boolean isSubPathV1(ListNode head, TreeNode root) {
        return dfsV1(head, root);
    }

    private boolean dfsV1(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (this.check(head, root)) return true;
        boolean left = this.isSubPathV1(head, root.left);
        if (left) return true;
        return isSubPathV1(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        if (this.check(head.next, root.left)) return true;
        if (this.check(head.next, root.right)) return true;
        return false;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtils.buildListNode(Arrays.asList(1,2,3));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(ReflectUtils.getInstance(R_IsSubPath_1367.class).check(head, root));
    }

    boolean rs;
    public boolean isSubPath(ListNode head, TreeNode root) {
        String listNodeStr = this.listToStr(head);
        this.dfs(root, listNodeStr, "");
        return rs;
    }

    private void dfs(TreeNode root, String target, String rootString) {
        if (rs) return;
        if (root == null) return;
        rootString += root.val + "-";
        if (rootString.contains(target)) {
            rs = true;
            return;
        }
        dfs(root.left, target, rootString);
        dfs(root.right, target, rootString);
    }

    private String listToStr(ListNode head) {

        StringBuilder s = new StringBuilder();
        while (head != null) {
            s.append(head.val);
            if (head.next != null) s.append("-");
            head = head.next;
        }
        return s.toString();
    }
}
