package com.leetcode.jolyon;

public class LC818RaceCar {
    public int racecar(int target) {
        int[] memo = new int[target + 1];
        int res = recur(memo, target);
        return res;
    }

    private int recur(int[] memo, int t) {
        if (memo[t] > 0) return memo[t];
        int n = ((int) (Math.log(t) / Math.log(2))) +1;
        if ((1 << n) == t + 1) {
            memo[t] = n;
            return n;
        }

        memo[t] = n + 1 + recur(memo, (1 << n) - 1 - t);
        for (int m = 0; m < n - 1; m++) {
            int cur = (1 << (n - 1) - (1 << m));
            memo[t] = Math.min(memo[t], n + m + 1 + recur(memo, t - cur));
        }
        return memo[t];
    }
}
