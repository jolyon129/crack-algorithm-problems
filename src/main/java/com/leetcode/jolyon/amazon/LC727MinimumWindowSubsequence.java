package com.leetcode.jolyon.amazon;

public class LC727MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }

        /**
         * we can conduct two steps by using two pointers for this probelm:
         * 1. check feasibility from left to right
         * 2. check optimization from right to left
         * we can traverse from left to right, find a possible candidate until reach the first ending character of T
         * eg: for the string s = abcdebdde and t = bde, we should traverse s string until we find first e,
         * i.e. abcde, then traverse back from current "e" to find if we have other combination of bde with smaller
         * length.
         * @param right: fast pointer that always points the last character of T in S
         * @param left: slow pointer that used to traverse back when right pointer find the last character of T in S
         * @param tIndex: third pointer used to scan string T
         * @param minLen: current minimum length of subsequence
         * */
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = -1, mintRight = S.length();
        String result = "";

        while (right < S.length()) {
            int tIndex = 0;
            // use fast pointer to find the last character of T in S
            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == T.length()) {
                    break;
                }
                right++;
            }

            // if right pointer is over than boundary
            if (right == S.length()) {
                break;
            }

            // use another slow pointer to traverse from right to left until find first character of T in S
            int left = right;
            tIndex = T.length() - 1;
            while (left >= 0) {
                if (S.charAt(left) == T.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0) {
                    break;
                }
                left--;
            }
            // if we found another subsequence with smaller length, update result
            if (mintRight-minLeft>right-left) {
                minLeft = left;
                mintRight = right;
            }
            // WARNING: we have to move right pointer to the next position of left pointer, NOT the next position
            // of right pointer
            right = left + 1;
        }
        if(minLeft==-1) return "";
        return S.substring(minLeft,mintRight+1);
    }
    public String minWindow1(String S, String T) {
        int left = 0, right = 0, tidx = 0;
        int minLeft = -1, minRight = S.length();
        while (right < S.length()) {
            char cur = S.charAt(right);
            if(cur==T.charAt(tidx)) tidx++;
            if (tidx==T.length()){
                int newLeft = right;
                for(int i= tidx-1;i>=0;i--){
                    while (S.charAt(newLeft)!=T.charAt(i)){
                        newLeft--;
                    }
                    if(i==0) break;
                    newLeft--;
                }
                left = newLeft;
                if(minRight-minLeft>right-left){
                    minLeft = left;
                    minRight = right;
                }
                // reset
                tidx = 0;
                // We need to start on right of the new left!
                right = left + 1;
            }else {
                right++;
            }
        }
        return minLeft==-1?"":S.substring(minLeft, minRight + 1);
    }

}
