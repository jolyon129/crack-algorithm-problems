package com.leetcode.jolyon;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public Node child;
    public Node prev;

    public Node(int val, Node o, Node o1) {}

    public Node(int val) {

        this.val = val;
    }

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
