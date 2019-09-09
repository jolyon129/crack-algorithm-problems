package com.leetcode.jolyon;

public class TwitterEfficientJobProcessingService {
    // If have to pick consecutive tasks and can only pick once for each task.
    public int maxTotalWeight(int[] tasks, int[] weights, int limit) {
        int curP = 0;
        int curW = 0;
        int res = 0;
        int i = 0;
        for (int j = 0; j < tasks.length; j++) {
            curP += 2 * tasks[j];
            curW += weights[j];
            while (i <= j && curP > limit) {
                curP -= 2 * tasks[i];
                curW -= weights[i];
                i++;
            }
            res = Math.max(curW, res);
        }
        return res;
    }

    // The real question, unbounded knapsack
    public int maxTotalWeightDP(int[] tasks, int[] weights, int limit) {
        int[][] dp = new int[tasks.length+1][limit+1];
        for(int i=1;i<=tasks.length;i++){
            for (int j =1;j<=limit;j++){
                if(2*tasks[i-1]>j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] =
                            Math.max(dp[i - 1][j - 2*tasks[i - 1]] + weights[i - 1],
                            dp[i-1][j]);
                }
            }
        }
        return dp[tasks.length][limit];
    }
}
