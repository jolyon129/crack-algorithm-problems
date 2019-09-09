package com.leetcode.jolyon;

public class KnapSack01 {

    public int knapSackIterative(int[] values, int[] weights, int W) {
        int[][] dp = new int[values.length + 1][W + 1];
        for (int i = 1; i < values.length + 1; i++) {
            for (int j = 1; j <= W; j++) {
                if (i == 0 || W == 0) {
                    dp[i][j] = 0;
                } else if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int val1 = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    int val2 = dp[i - 1][j];
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        return dp[values.length][W];
    }
}
