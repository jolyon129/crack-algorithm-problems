package com.leetcode.jolyon;

public class LC965UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        return isValid(root, root.val);
    }
    public boolean isValid(TreeNode root, int val){
        if(root.val!=val){
            return false;
        }
        boolean leftRes = true;
        boolean rightRes = true;
        if(root.left!=null)  leftRes = isValid(root.left, val);
        if(root.right!=null)  rightRes = isValid(root.right, val);
        return leftRes&&rightRes;
    }
}
