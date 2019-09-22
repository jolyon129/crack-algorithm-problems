package com.leetcode.jolyon;

public class LC101SymmetricTree {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root ==null) return true;
            return compare(root.left, root.right);
        }
        private boolean compare(TreeNode p, TreeNode q){
            if(p==null&&q==null) return true;
            if(p==null||q==null||p.val!=q.val) return false;
            return compare(p.left, q.right)&&compare(p.right, q.left);
        }
    }
}
