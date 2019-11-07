package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.Stack;

public class LC1214TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> tmp = new Stack<>();
        TreeNode node2 = root2;
        while (node2 != null || !tmp.isEmpty()) {
            while (node2 != null) {
                tmp.add(node2);
                node2 = node2.left;
            }
            node2 = tmp.pop();
            stack2.add(node2);
            node2 = node2.right;
        }
        TreeNode node1 = root1;
        int val1;
        int val2 = stack2.peek().val;
        while (node1 != null || !stack1.isEmpty()) {
            while (node1 != null) {
                stack1.add(node1);
                node1 = node1.left;
            }
            node1 = stack1.pop();
            val1 = node1.val;
            while (val1 + val2 > target && !stack2.isEmpty()) {
                val2 = stack2.pop().val;
            }
            if(val1+val2 ==target) return true;
            node1 = node1.right;
        }
        return false;
    }

}
