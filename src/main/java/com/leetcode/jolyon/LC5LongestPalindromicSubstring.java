package com.leetcode.jolyon;

public class LC5LongestPalindromicSubstring {
    int left = 0;
    int right = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l > right - left) {
                right = r;
                left = l;
            }
            l--;
            r++;

        }

    }
}
