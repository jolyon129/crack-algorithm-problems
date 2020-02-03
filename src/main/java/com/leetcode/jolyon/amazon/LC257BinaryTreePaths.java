package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePaths {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        ans = new ArrayList<String>();
        String path = "" + root.val;
        if (root.left != null) {
            recur(root.left, path);
        }
        if (root.right != null) {
            recur(root.right, path);
        }
        if (root.right == null && root.left == null) {
            ans.add(path);
        }
        return ans;
    }

    public void recur(TreeNode root, String path) {
        path += "->" + root.val;
        if (root.left != null) {
            recur(root.left, path);
        }
        if (root.right != null) {
            recur(root.right, path);
        }
        // Only add to path when hit a leaf node
        if (root.right == null && root.left == null) {
            ans.add(path);
        }


    }
}
