package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class LC124BinaryTreeMaximumPathSum {
    /**
     * Definition for a binary tree node. public class TreeNode { int val;
     * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    static class Solution {
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            arrowSum(root);
            return ans;
        }

        private int arrowSum(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = arrowSum(node.left);
            int right = arrowSum(node.right);
            int arrow = Math.max(left + node.val, right + node.val);
            // only itself
            arrow = Math.max(arrow, node.val);
            if (node.val + left + right > arrow) {
                ans = Math.max(ans, node.val + left + right);
            } else {
                ans = Math.max(ans, arrow);
            }
            return arrow;
        }
    }

    static class Solution2 {
        Integer ans = Integer.MIN_VALUE;
        Integer maxSumIncludingRoot = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxSum(root);

            return Math.max(ans, maxSumIncludingRoot);
        }

        private int maxSum(TreeNode root) {
            if (root == null) return 0;
            int leftSum = maxSum(root.left);
            int rightSum = maxSum(root.right);
            maxSumIncludingRoot = Math.max(maxSumIncludingRoot, leftSum + rightSum + root.val);
            ans = Math.max(root.val + leftSum, root.val + rightSum);
            ans = Math.max(root.val, ans);
            return ans;
        }
    }

    static class Solution3 {
        int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            recur(root);
            return ans;
        }

        int recur(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = node.val + recur(node.left);
            int right = node.val + recur(node.right);
            ans = Math.max(right, (Math.max(left, ans)));
            ans = Math.max(ans, left + right - node.val);
            ans = Math.max(node.val, ans);
            return Math.max(node.val, Math.max(left, right));
        }
    }
}
