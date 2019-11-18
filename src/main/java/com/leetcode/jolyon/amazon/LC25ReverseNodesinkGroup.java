package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.ListNode;

public class LC25ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        int t = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        ListNode prev = dummy;
        ListNode beforeStart = dummy;
        ListNode start = head;
        while (t <= k) {
            if (node == null) {
                break;
            }
            if (t == 1) {
                beforeStart = prev;
                // start on the new node
                start = node;
            }else if (t == k) {
                reverse(beforeStart, start, t);
                // The current node has been changed to `start`
                node = start; //IMPORTANT!
                // reset t to 0
                t = 0;
            }
            prev = node;
            node = node.next;
            t++;

        }
        return dummy.next;
    }
    // reverse the list starting from the node and ending at the t
    void reverse(ListNode prev, ListNode node, int t) {
        ListNode beforeStart = prev;
        // The tail of the reverse linked list is the head of the original one
        ListNode tailOfReversed = node;
        ListNode cur = node;
        while (t > 0) {
            ListNode next = cur.next;
            // reverse the link between the cur with the prev
            cur.next = prev;
            prev = cur;
            cur = next;
            t--;
        }
        // After the loop, the beforeStart and tailOfReversed are messed!
        // handle the beforeStart and the tailOfReversed !
        beforeStart.next = prev;
        tailOfReversed.next = cur;
    }
}

