package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.Stack;

public class LC230KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if(k==0){
                return node.val;
            }
            node = node.right;
        }

        return -1; // never hit if k is valid
    }
}
