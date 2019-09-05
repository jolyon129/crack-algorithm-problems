package com.leetcode.jolyon;

public class LC110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int result = getDepth(root);
        return true ? result != -1 : false;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        if (left > right + 1 || right > left + 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
