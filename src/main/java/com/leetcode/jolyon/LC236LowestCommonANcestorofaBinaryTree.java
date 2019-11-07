package com.leetcode.jolyon;

public class LC236LowestCommonANcestorofaBinaryTree {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root, p, q);
        return ans;
    }

    boolean recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean current = root.val == p.val || root.val == q.val;
        boolean l = recur(root.left, p, q);
        boolean r = recur(root.right, p, q);
        if (l && r || l && current || r && current || current && p.val == q.val) {
            this.ans = root;
        }
        return current || l || r;
    }
}
