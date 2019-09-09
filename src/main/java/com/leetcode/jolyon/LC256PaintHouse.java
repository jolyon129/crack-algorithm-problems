package com.leetcode.jolyon;

public class LC256PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int N = costs.length;
        Integer[][] dp = new Integer[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1]+costs[i][0],dp[i-1][2]+costs[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+costs[i][1],dp[i-1][2]+costs[i][1]);
            dp[i][2] = Math.min(dp[i-1][1]+costs[i][2],dp[i-1][0]+costs[i][2]);
        }
        int ans = Math.min(dp[N - 1][0], dp[N - 1][1]);
        ans = Math.min(ans, dp[N - 1][2]);
        return ans;
    }
}
