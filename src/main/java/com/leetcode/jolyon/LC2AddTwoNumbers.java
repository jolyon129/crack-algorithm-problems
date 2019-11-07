package com.leetcode.jolyon;

public class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1node = l1;
        ListNode l2node = l2;
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(l1node!=null||l2node!=null){
            int val1 = l1node ==null?0:l1node.val;
            int val2 = l2node ==null?0:l2node.val;
            int n = (val2+val1+carry)%10;
            carry = (val2+val1+carry)/10;
            ListNode node = new ListNode(n);
            cur.next = node;
            cur = node;
            if(l1node!=null) l1node = l1node.next;
            if(l2node!=null) l2node = l2node.next;
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
