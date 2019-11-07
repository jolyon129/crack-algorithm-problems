package com.leetcode.jolyon;

public class LC206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        if(head==null) return null;
        recur(head, head.next, dummy);
        return dummy.next;
    }
    private void recur(ListNode prev, ListNode node, ListNode dummy){
        if(node==null){
            dummy.next = prev;
            return;
        }
        recur(node, node.next, dummy);
        node.next = prev;
        prev.next = null;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}
