package com.leetcode.jolyon;

import java.util.Stack;

/**
 * Hard!
 */
public class LC99RecoverBinarySearchTree {
    class SolutionMorris{
        public void recoverTree(TreeNode root) {
            // predecessor is a Morris predecessor.
            // In the 'loop' cases it could be equal to the node itself predecessor == root.
            // pred is a 'true' predecessor,
            // the previous node in the inorder traversal.
            TreeNode x = null, y = null, pred = null, predecessor = null;

            while (root != null) {
                // If there is a left child, try to build the thread, then go left.
                // If not, try to build the thread.
                if (root.left != null) {
                    //In current's left subtree, make current node, the right
                    // child of the rightmost node of the left subtree
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root){
                        predecessor = predecessor.right;
                    }

                    // set link predecessor.right = root
                    // and go to explore left subtree
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    else {
                        // break link predecessor.right = root
                        // link is broken : timestamp to change subtree and go right

                        // simulate for the swapped nodes
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) x = pred;
                        }
                        pred = root;

                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // If there is no left child
                // then just go right.
                else {
                    // simulate for the swapped nodes
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) x = pred;
                    }
                    pred = root;

                    root = root.right;
                }
            }
            swap(x, y);
        }

    }
    class SolutionIterativeInOrder{
        // In-order
        public void recoverTree(TreeNode node) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode x = null, y = null, prev = null;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
                node = stack.pop();
                if (prev != null && node.val < prev.val) {
                    // The first timestamp we met a mismatched situation, the
                    // target is the prev node, while the second timestamp should
                    // be the current node
                    // Always assign the current node to y

                    // This can handle the situation when there two swapped
                    // elements are consecutive
                    y = node;
                    // If haven't found the first number
                    if (x == null) x = prev;
                        // else y = cur which has already be done.
                    else break;
                }
                prev = node;
                node = node.right;
            }

            swap(x, y);
        }
    }
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }



}
