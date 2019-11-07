package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class LC572SubtreeofAnontherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        int target = s.val;
        return visit(t, target, s);
    }

    private boolean visit(TreeNode node, int target, TreeNode subtree) {
        if (node == null) return false;
        boolean flag3 = false;
        if (node.val == target) {
            flag3 = check(node, subtree);
            if(flag3) return true;
        }
        boolean flag1, flag2;
        flag1 = visit(node.left, target, subtree);
        flag2 = visit(node.right, target, subtree);
        return flag1 || flag2;

    }

    private boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null && a.val == b.val) {
            return check(a.left, b.left) && check(a.right, b.right);
        } else {
            return false;
        }

    }
}
