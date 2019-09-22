package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94BinaryTreeInorderTraversal {
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                recur(root, res);
            }
            return res;
        }

        private void recur(TreeNode root, List<Integer> res) {
            if (root.left != null) recur(root.left, res);
            res.add(root.val);
            if (root.right != null) recur(root.right, res);
        }

        public List<Integer> inorderTraversalIterative(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode nextNode = root;
            while (!(stack.isEmpty() && nextNode == null)) {
                while (nextNode != null) {
                    stack.push(nextNode);
                    nextNode = nextNode.left;
                }
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                nextNode = tmp.right;
            }
            return res;
        }

        public List<Integer> inorderTraversalMorris(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode cur = root;
            while (cur != null) {
                if (cur.left == null) {
                    res.add(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode pre = cur.left;
                    while (pre.right != null && pre.right != cur) {
                        pre = pre.right;
                    }
                    if (pre.right != cur) {
                        pre.right = cur;
                        cur = cur.left;
                    } else {
                        // If programm runs into here, it means that we have already visited the left subtree of the current node
                        res.add(cur.val);
                        pre.right = null;
                        cur = cur.right;
                    }
                }
            }
            return res;
        }
    }


}
