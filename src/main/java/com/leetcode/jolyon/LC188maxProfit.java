package com.leetcode.jolyon;

/**
 * LC188maxProfit
 */
public class LC188maxProfit {
    public int maxProfit(int k, int[] prices) {
        int sell;
        int diff;
        if(k>prices.length/2){
            return quickSolve(k, prices);
        }
        int[][] dp = new int[k + 1][prices.length];
        // Initialize
        for (int i = 0; i < prices.length; i++) {
            dp[0][i] = 0;
        }
        // Initialize
        for (int i = 0; i < k+1; i++) {
            dp[i][0] = 0;
        }
        for(int t=1;t<k+1;t++){
            sell = 0;
            for(int i=1;i<prices.length;i++){
                diff = prices[i]-prices[i-1];
                sell = Math.max(sell, dp[t-1][i-1])+diff;
                dp[t][i] = Math.max(sell, dp[t][i-1]);
            }

        }
        return dp[k][prices.length-1];
    }
    private int quickSolve(int k, int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}