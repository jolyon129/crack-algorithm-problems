package com.leetcode.jolyon;

public class LC687LongestUnivaluePath {
    static class Solution {
        int ans;
        public int longestUnivaluePath(TreeNode root) {
            ans = 1;
            arrowSize(root);
            //Edge = number of nodes -1
            return ans-1;
        }
        // The number of nodes
        public int arrowSize(TreeNode node) {
            if (node == null) return 0;
            int left = arrowSize(node.left);
            int right = arrowSize(node.right);
            int arrowLeft = 1, arrowRight = 1;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft = left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                arrowRight = right + 1;
            }
            ans = Math.max(ans, arrowLeft + arrowRight-1);
            return Math.max(arrowLeft, arrowRight);
        }
    }}
