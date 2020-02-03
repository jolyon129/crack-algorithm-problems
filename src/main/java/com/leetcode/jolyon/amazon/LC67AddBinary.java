package com.leetcode.jolyon.amazon;

public class LC67AddBinary {
    public String addBinary(String a, String b) {
        int N = a.length(), M = b.length();
        // Always let the bigger one start
        if (N < M) return addBinary(b, a);
        int L = N;

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = M - 1;
        for(int i = L - 1; i > -1; --i) {
            int tmp = 0;
            if (a.charAt(i) == '1') ++tmp;
            if (j > -1 && b.charAt(j--) == '1') ++tmp;
            tmp += carry;
            if (tmp % 2 == 1) sb.append('1');
            else sb.append('0');
            carry = tmp / 2;
        }
        if (carry == 1) sb.append('1');
        // remember to reverse!
        sb.reverse();

        return sb.toString();
    }
}
