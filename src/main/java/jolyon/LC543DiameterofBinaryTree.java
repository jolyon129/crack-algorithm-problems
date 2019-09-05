package com.leetcode.jolyon;

public class LC543DiameterofBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        ans = 0;
        recur(root);
        return ans;
    }

    private int recur(TreeNode root){
        if(root.left==null && root.right==null){
            return 0;
        }
        int left = -1;
        int right = -1;
        if(root.left!=null){
            left = recur(root.left);
        }
        if(root.right!=null){
            right = recur(root.right);
        }
        int tmp = Math.max(1+left,1+right);
        ans = Math.max(ans, Math.max(tmp, left+right+2));
        return tmp;
    }
}
