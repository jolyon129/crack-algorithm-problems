package com.leetcode.jolyon.bloomberg;

import com.leetcode.jolyon.Node;

public class LC430FlattenaMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        concatenate(head);
        return head;
    }

    // concatenate: flatten the node "head" and return the tail in its child (if exists)
    // the tail means the last node after flattening "head"

    // Five situations:
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next - flatten the child, connect it with the next, go next

    // at each recursion, return the tail of the possible child. if not,
    // return itself.
    private Node concatenate(Node head) {
        if (head == null) return head; // CASE 1
        if (head.child == null) {
            if (head.next == null) return head; // CASE 2
            return concatenate(head.next); // CASE 3
        }
        else {
            Node child = head.child;
            head.child = null;
            Node next = head.next;
            Node tailOfChild = concatenate(child);
            head.next = child;
            child.prev = head;
            if (next != null) { // CASE 5
                tailOfChild.next = next;
                next.prev = tailOfChild;
                return concatenate(next);
            }
            return tailOfChild; // CASE 4
        }
    }
}
