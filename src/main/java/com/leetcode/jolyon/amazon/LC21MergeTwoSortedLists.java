package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.ListNode;

public class LC21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode pseudo = new ListNode(-1);
        ListNode cur = pseudo;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1!=null){
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return pseudo.next;
    }
}
