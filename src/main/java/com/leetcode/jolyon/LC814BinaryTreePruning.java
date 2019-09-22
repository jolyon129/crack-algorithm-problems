package com.leetcode.jolyon;

public class LC814BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
        boolean l = containsOne(root.left);
        boolean r = containsOne(root.right);
        if (!l) root.left = null;
        if (!r) root.right = null;
        if (root.val == 1) return true;
        else return l || r;
    }

}
