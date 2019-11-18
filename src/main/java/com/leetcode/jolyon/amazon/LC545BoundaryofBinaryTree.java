package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC545BoundaryofBinaryTree {
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if (root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }

    public void leftBoundary(TreeNode root) {
        // If root.left and root.right both equals to null, then this is also a
        // leaf node, in order to eliminate duplicates, we doesn't count them as
        // left boundary
        if (root == null || (root.left == null && root.right == null)) return;
        // Add them along the order of recursion
        nodes.add(root.val);
        //Only go right if left is null
        if (root.left != null) leftBoundary(root.left);
        else leftBoundary(root.right);
    }

    public void rightBoundary(TreeNode root) {
        // Again, avoid duplicates
        if (root == null || (root.right == null && root.left == null)) return;
        if (root.right != null) rightBoundary(root.right);
        else rightBoundary(root.left);
        nodes.add(root.val); // add after recursion(reverse)

    }

    public void leaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        // from left to right
        leaves(root.left);
        leaves(root.right);
    }
}
