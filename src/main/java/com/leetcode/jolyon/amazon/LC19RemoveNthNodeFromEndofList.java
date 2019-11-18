package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.ListNode;

public class LC19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pseudo = new ListNode(-1);
        pseudo.next = head;
        ListNode fast = head;
        while (n>0){
            fast = fast.next;
            n--;
        }
        ListNode cur = head;
        ListNode pre = pseudo;
        while (fast!=null){
            pre = cur;
            fast = fast.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        return pseudo.next;
    }
}
