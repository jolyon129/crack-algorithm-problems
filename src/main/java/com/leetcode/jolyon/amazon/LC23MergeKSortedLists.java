package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC23MergeKSortedLists {
    // use priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((ListNode w) -> w.val));
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (pq.size() != 0) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return head.next;

    }

    // O(1) space
    public ListNode mergeKLists1(ListNode[] lists) {
        int N = lists.length;
        if(N==0) return null;
        int interval = 1;
        while (interval < N) {
            // Memorize this!!!
            for (int i = 0; i < N-interval; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if(node1.val<node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if(node1!=null){
            cur.next = node1;
        }
        if(node2!=null){
            cur.next = node2;
        }
        return dummy.next;
    }
}
