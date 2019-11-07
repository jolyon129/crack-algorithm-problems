package com.leetcode.jolyon;

public class LC309BestTimetoBuyandSellStockwihCoolDown {
    public int maxProfit(int[] prices) {
        //dp[i] = max(dp[i-1], prices[i] - (prices[j] - dp[j-2])), j=[0..i-1]
        if (prices.length < 2) return 0;
        int[] dp = new int[prices.length + 1]; // use 1 more to guard
        int min = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            int priceIdx = i - 1;
            min = Math.min(min, prices[priceIdx] - dp[i - 2]);
            dp[i] = Math.max(dp[i-1], prices[priceIdx] - min);
        }
        return dp[dp.length - 1];
    }
}
