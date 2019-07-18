package edu.nyu.jolyon;

public class LC142LinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            ListNode tmp = fast;
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return slow;
            }

        }
        return null;
    }
}
