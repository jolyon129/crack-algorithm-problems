package com.leetcode.jolyon.bloomberg;

import com.leetcode.jolyon.Node;

import java.util.HashMap;

public class LC138CopyListWithRandomPointer {
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
    */

    // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node originalNode = head;
        // head
        Node pseudoHead = new Node(-1);
        Node prevNewNode = pseudoHead;
        while (originalNode != null) {
            Node newNode;
            if (visited.containsKey(originalNode)) {
                newNode = visited.get(originalNode);
            } else {
                newNode = new Node(originalNode.val);
                visited.put(originalNode, newNode);
            }
            Node oldRandom = originalNode.random;
            if (oldRandom != null) {
                if (visited.containsKey(oldRandom)) {
                    newNode.random = visited.get(oldRandom);
                } else {
                    newNode.random = new Node(oldRandom.val);
                    visited.put(oldRandom, newNode.random);
                }
            }

            prevNewNode.next = newNode;
            prevNewNode = newNode;
            originalNode = originalNode.next;
        }
        return pseudoHead.next;
    }

}
