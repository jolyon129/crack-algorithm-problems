package com.leetcode.jolyon;

public class LC114FlattenBinaryTreeToLinkedList {
    static class Try {
        public void flatten(TreeNode root) {
            TreeNode prev = null;
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    System.out.print(current.val + " ");
                    if(prev!=null){
                        prev.right = current;
                        prev.left = null;
                    }
                    prev = current;
                    current = current.right;
                } else {
                    TreeNode predecessor = current.left;
                    while (predecessor.right != current && predecessor.right != null) {
                        predecessor = predecessor.right;
                    }
                    if (predecessor.right == null) {
                        predecessor.right = current;
                        if(prev!=null){
                            prev.right = current;
                            prev.left = null;
                        }
                        prev = current;
                        System.out.print(current.val + " ");
                        current = current.left;
                    } else {
//                        predecessor.right = null;
                        current = current.right;
                    }
                }
            }
        }
    }

    static class MyMorrisTraversal {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur != null) {
                // System.out.print(cur.val + " ");
                if (cur.left != null) {
                    TreeNode last = cur.left;
                    while (last.right != null) last = last.right;
                    // The biggest difference from morris traversal.
                    // Since we don't need to delete the extra "link",
                    // we can go further.
                    last.right = cur.right;
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
