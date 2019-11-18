package com.leetcode.jolyon.amazon;

public class LC96UniqueBST {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        // Be careful!
        // We can leave one subtree empty
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
