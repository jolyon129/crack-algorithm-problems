package com.leetcode.jolyon;

public class LC116PopulatingNextRightPointers {
    static class Solution {
        public Node connect(Node root) {
            Node head = root;
            if (root == null) return root;
            while (root != null && root.left != null) {
                Node parentHead = root;
                while (parentHead  != null) {
                    parentHead.left.next = parentHead.right;
                    parentHead.right.next = parentHead.next == null ? null : parentHead.next.left;
                    parentHead = parentHead.next;
                }
                root = root.left;
            }
            return head;
        }
    }
}
