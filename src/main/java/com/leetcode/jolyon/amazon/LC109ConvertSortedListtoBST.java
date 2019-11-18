package com.leetcode.jolyon.amazon;

import com.leetcode.jolyon.ListNode;
import com.leetcode.jolyon.TreeNode;

public class LC109ConvertSortedListtoBST {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        int size = 0;
        while(node!=null){
            size++;
            node =node.next;
        }
        node = head;
        return recur(0,size);
    }
    TreeNode recur(int in_left, int in_right) {
        if (node==null||in_left == in_right) return null;
        int in_mid = (in_right - in_left) / 2 + in_left;
        System.out.print(in_mid);
        TreeNode left = recur(in_left, in_mid);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        TreeNode right = recur(in_mid+1, in_right);
        root.right = right;
        return root;
    }
}
