package com.leetcode.jolyon.amazon;

public class LC125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        while (head <= tail) {
            while (head <= tail && !Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            }
            while (head <= tail && !Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            }
            if (head <= tail && Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;

        }
        return true;
    }
}
