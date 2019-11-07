package com.leetcode.jolyon;

public class LC746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = cost[0];
        int prev1 = cost[1];
        int ans = Math.min(prev2, prev1);
        for (int i = 2; i < cost.length; i++) {
            ans = Math.min(prev2, prev1) + cost[i];
            if (i < cost.length-1) {
                prev2 = prev1;
                prev1 = ans;
            }
        }
        return Math.min(ans, prev1);
    }
}
