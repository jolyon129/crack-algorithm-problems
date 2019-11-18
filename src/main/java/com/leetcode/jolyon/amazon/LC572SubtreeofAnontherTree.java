package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class LC572SubtreeofAnontherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        int target = t.val;
        return dfs(s, target, t);
    }

    private boolean dfs(TreeNode node, int target, TreeNode subtree) {
        if (node == null) return false;
        if (node.val == target && check(node, subtree)) {
            // If equals false, we cannot return false directly!
            return true;
        }
        boolean flag1, flag2;
        flag1 = dfs(node.left, target, subtree);
        flag2 = dfs(node.right, target, subtree);
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
