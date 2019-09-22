package com.leetcode.jolyon;

public class LC100SameTree {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSame(p, q);
        }
        private boolean isSame(TreeNode p, TreeNode q){
            if(p==null&&q==null) return true;
            if( p==null || q==null || p.val!=q.val) return false;
            return isSame(p.left, q.left) & isSame(p.right, q.right);
        }
    }
}
