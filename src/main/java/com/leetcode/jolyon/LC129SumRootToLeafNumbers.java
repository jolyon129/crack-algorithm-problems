package com.leetcode.jolyon;

public class LC129SumRootToLeafNumbers {
    class Solution {
        int ans=0;
        public int sumNumbers(TreeNode root) {
            if(root ==null) return 0;
            StringBuilder digit = new StringBuilder();
            recur(root,digit);
            return ans;
        }
        private void recur(TreeNode root, StringBuilder digit){
            digit.append(root.val);
            int length = digit.length();
            if(root.left==null&&root.right==null){
                ans += Integer.valueOf(digit.toString());
                return;
            }
            if(root.left!=null){
                recur(root.left, digit);
            }
            digit.setLength(length);
            if(root.right!=null){
                recur(root.right, digit);
            }

        }
    }
}
