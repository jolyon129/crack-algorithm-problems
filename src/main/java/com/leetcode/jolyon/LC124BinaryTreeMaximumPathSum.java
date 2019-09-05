package com.leetcode.jolyon;

public class LC124BinaryTreeMaximumPathSum {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        int ans=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            sum(root);
            return ans;
        }
        private int sum(TreeNode node){
            if(node==null){
                return 0;
            }
            int s1 = sum(node.left);
            int s2 = sum(node.right);
            int maxEndingSum = Math.max(s1+node.val,s2+node.val);
            maxEndingSum = Math.max(maxEndingSum,node.val);

            if(node.val+s1+s2>maxEndingSum){
                ans = Math.max(ans, node.val+s1+s2);
            }else{
                ans = Math.max(ans,maxEndingSum);
            }
            return maxEndingSum;
        }
    }
}
