package com.leetcode.jolyon;

public class LC1201UglyNumber3 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        int mid;
        int res = 0;
        while (lo < hi) {
            mid = (hi - lo) / 2 + lo;
            int cnt = count(a, b, c, mid);
            if (cnt < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);

    }

    long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    int count(int a, int b, int c, int num) {
        return (int) (num / a + num / b + num / c - num / lcm(a, b) - num / lcm(b, c) - num / lcm(a,
                c) + num / lcm(a, lcm(b, c)));
    }

}
