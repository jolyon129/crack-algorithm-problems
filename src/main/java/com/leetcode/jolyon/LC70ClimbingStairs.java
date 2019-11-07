package com.leetcode.jolyon;

public class LC70ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }

}
