package com.leetcode.jolyon;

public class LC114FlattenBinaryTreeToLinkedList {


    static class MyMorrisTraversal {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                // System.out.print(cur.val + " ");
                if (cur.left != null) {
                    TreeNode prev = cur.left;
                    while (prev.right != null) prev = prev.right;
                    // we're doing preorder here!
                    // The biggest difference from morris traversal.
                    // Since we don't need to delete the extra "link",
                    // we can go further.
                    // we dont need to link prev.right to cur
                    prev.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                }
                cur = cur.right;

            }
        }

    }

    static class reversedPreorder {
        private TreeNode prev = null;

        public void reversedPreorder(TreeNode root) {
            if (root == null)
                return;
            reversedPreorder(root.right);
            reversedPreorder(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }
}
