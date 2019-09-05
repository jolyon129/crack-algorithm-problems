package com.leetcode.jolyon;

public class LC121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int leftMin= prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            leftMin=Math.min(leftMin,prices[i]);
            ans = Math.max(ans,prices[i]-leftMin);
        }
        return ans;
    }
}
