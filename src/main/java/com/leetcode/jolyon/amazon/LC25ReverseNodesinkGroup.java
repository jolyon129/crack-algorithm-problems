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
        ListNode beforeStart = prev;
        ListNode start = head;
        while (t <= k) {
            if (node == null) {
                break;
            }
            if (t == 1) {
                beforeStart = prev;
                start = node;
            }
            if (t == k) {
                reverse(beforeStart, start, t);
                // The current node has been changed to `start`
                node = start;
                t = 0;
            }
            prev = node;
            node = node.next;
            t++;

        }
        return dummy.next;
    }

    void reverse(ListNode prev, ListNode node, int t) {
        ListNode beforeStart = prev;
        ListNode tailOfReversed = node;
        ListNode cur = node;
        while (t > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            t--;
        }

        beforeStart.next = prev;
        tailOfReversed.next = cur;
    }
}

