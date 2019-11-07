package com.leetcode.jolyon.bloomberg;

public class LC7ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            int e1 = Integer.MAX_VALUE % 10;
            int e2 = Integer.MIN_VALUE % 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > e1)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < e2)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
