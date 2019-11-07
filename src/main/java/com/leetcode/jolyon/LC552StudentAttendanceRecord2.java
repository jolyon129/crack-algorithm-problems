package com.leetcode.jolyon;

public class LC552StudentAttendanceRecord2 {
    public int checkRecord(int n) {
        /**
         * sum(n) the number where we have n characters.
         */
        // sum(n) -> noAsum(n)+ Asum(n)
        // P(n), L(n),
        // noAsum(n) = P(n)+L(n)
        /**
         *
         * P'(n) = P(n-1) + L(n-1);
         * L'(n) = P(n-1) + P(n-2);
         * noAsum(n) = P'(n) + L'(n)
         *
         * Asum(n) += noAsum(i)*noAsum(n-i-1) where i in range(0, n)
         */
        if (n == 1) return 3;
        int MOD = 1_000_000_000 + 7;
        long[] noAsum = new long[n + 1];
        long[] P = new long[n + 1];
        long[] L = new long[n + 1];
        P[1] = 1;
        L[1] = 1;
        L[2] = 2; // PL, LL
        for (int i = 1; i < n + 1; i++) {
            if (i > 1) {
                P[i] = (P[i - 1] + L[i - 1]) % MOD;
            }
            if (i > 2) {
                L[i] = (P[i - 1] + P[i - 2]) % MOD;
            }
            noAsum[i] = (P[i] + L[i]) % MOD;
        }
        noAsum[0] = 1;
        long withAsum = 0;
        for (int i = 0; i < n; i++) {
            {
                withAsum = (withAsum + noAsum[i] * noAsum[n - 1 - i] % MOD)%MOD;
            }
        }
        return (int) (withAsum+noAsum[n])%MOD;
    }
}
