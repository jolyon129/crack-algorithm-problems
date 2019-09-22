package com.leetcode.jolyon;

public class LC669TrimpaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root ==null) return null;
        root.right = trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        if(root.val<L){
            return root.right;
        }
        else if(root.val>R){
            return root.left;
        }else{
            return root;
        }
    }
}
