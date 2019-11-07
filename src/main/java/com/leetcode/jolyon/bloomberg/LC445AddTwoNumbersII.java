package com.leetcode.jolyon.bloomberg;

import com.leetcode.jolyon.ListNode;

import java.util.Stack;

public class LC445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        ;
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;

        ListNode dummyHead = new ListNode(-1);
        int carry = 0;
        while (!s1.empty() || !s2.empty()) {
            sum = 0;
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }

        return dummyHead.next;
    }


}
