package com.leetcode.jolyon;

public class LC1000MinimumCosttoMergeStones {
    int[][][] dp;
    int max = Integer.MAX_VALUE;
    int K;

    public int mergeStones(int[] stones, int K) {
        this.K = K;
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        dp = new int[len + 1][len + 1][K + 1];
        int[] prefixSum = new int[len + 1];


        for (int i = 0; i <len; i++) {
            prefixSum[i+1] = prefixSum[i] + stones[i];
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<dp[0][0].length;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        getResult(prefixSum, 1, len, 1);
        return dp[1][len][1];
    }

    private int getResult(int[] prefixSum, int left, int right, int piles) {
        if (dp[left][right][piles] != -1) {
            return dp[left][right][piles];
        }
        int res = max;
        int t;
        if (left == right) {
            res = (piles == 1) ? 0 : max;
        }
        else {
            if (piles == 1) {
                int mergeK = getResult(prefixSum, left, right, K);
                //The idea of MAX is to mark the invalid state. If we don't check, the res may be negative, cause Integer.MAX_VALUE + 1 = Integer.MIN_VALUE.
                if (mergeK != max) {
                    res = mergeK + prefixSum[right] - prefixSum[left - 1];
                }
            }
            else {
                for (t = left; t < right; t++) {
                    int l = getResult(prefixSum, left, t, piles - 1);
                    int r = getResult(prefixSum, t + 1, right, 1);
                    if (l != max && r != max) {
                        res = Math.min(res, l + r);
                    }
                }
            }
        }
        dp[left][right][piles] = res;
        return res;
    }
}
