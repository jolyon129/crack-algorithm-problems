package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class LC104MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return recur(root);
    }
    int recur(TreeNode node){
        if(node == null) return 0;
        return Math.max(recur(node.left)+1,recur(node.right)+1);
    }
}
