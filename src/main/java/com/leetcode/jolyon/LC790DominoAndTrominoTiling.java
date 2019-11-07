package com.leetcode.jolyon;

public class LC790DominoAndTrominoTiling {
    public int numTilings(int N) {
        long[] g = new long[1000 + 1];
        long[] u = new long[1000 + 1];
        g[0] = 0;
        g[1] = 1;
        g[2] = 2;
        u[0]=0;
        u[1]=1;
        u[2]=2;
        int mod = 1000000007;
        for (int i = 3; i <= N; i++) {
            u[i] = (u[i - 1] + g[i - 1]) % mod;
            g[i] = (g[i - 1] + g[i - 2] + 2 * u[i - 2]) % mod;
        }
        return (int)g[N] % mod;
    }
}
