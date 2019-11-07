package com.leetcode.jolyon;

public class LC123BestTimetoBuyandSell {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length+1];
        int min = prices[0];
        for (int k = 1; k <= 2; k++) {
            min = prices[0];
            for (int i = 2; i <= prices.length; i++) {
                int priceIdx = i-1;
                min = Math.min(min, prices[priceIdx] - dp[k - 1][i - 1]);
                dp[k][i] =Math.max(dp[k][i - 1],prices[priceIdx] - min);
            }
        }

        return dp[2][prices.length];
    }
}

