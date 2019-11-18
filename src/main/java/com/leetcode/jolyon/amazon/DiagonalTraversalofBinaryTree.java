package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
public class DiagonalTraversalofBinaryTree {
    static void solve(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // The null used to tell the end of the current level!
        queue.add(null);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur == null) {
                System.out.print("\n");
                System.out.println("new level");
                // Add a mark to the end of the current level
                queue.add(null);
                // Read the head of the current level
                cur = queue.poll();
                if (cur == null) break;
            }
            while (cur != null) {
                System.out.print(cur.val + ",");
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(8, new ArrayList());
        root.left = new Node(3, new ArrayList());
        root.right = new Node(10, new ArrayList());
        root.left.left = new Node(1, new ArrayList());
        root.left.right = new Node(6, new ArrayList());
        root.right.right = new Node(14, new ArrayList());
        root.right.right.left = new Node(13, new ArrayList());
        root.left.right.left = new Node(4, new ArrayList());
        root.left.right.right = new Node(7, new ArrayList());

        solve(root);
    }

}
