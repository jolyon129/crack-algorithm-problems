package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.TreeNode;

public class FoldableBinaryTrees {
    boolean isFoldable(TreeNode root) {
        if (root == null) return false;
        if ((root.left == null && root.right == null)) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isStructSame(root.left, root.right);
        } else {
            return false;
        }
    }

    boolean isStructSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null))
            return false;
        return isStructSame(n1.left, n2.right) && isStructSame(n1.right, n2.left);
    }
}
