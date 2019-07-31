package edu.nyu.jolyon;

import java.util.*;

public class LC116PopulatingNextRightPointers {
    static class Solution {
        public Node connect(Node root) {
            Node head = root;
            if (root == null) return root;
            while (root != null && root.left != null) {
                Node cur = root;
                while (cur  != null) {
                    cur.left.next = cur.right;
                    cur.right.next = cur.next == null ? null : cur.next.left;
                    cur = cur.next;
                }
                root = root.left;
            }
            return head;
        }
    }
}
