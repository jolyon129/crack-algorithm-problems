package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC1027LongestArithmeticSequence {
    public int longestArithSeqLength(int[] A) {
        int N = A.length;
        int ans = -1;
        Map<Integer, Integer>[] diffMap = new Map[N];
        int[] dp = new int[N];
        dp[1] = 2;
        diffMap[0] = new HashMap<>();
        for (int j = 1; j < N; j++) {
            diffMap[j] = new HashMap<>();
            dp[j] = 2;
            for (int i = 0; i < j; i++) {
                int diff = A[j] - A[i];
                if (diffMap[i].containsKey(diff)) {
                    dp[j] = Math.max(diffMap[i].get(diff) + 1, dp[j]);
                    diffMap[j].put(diff,diffMap[i].get(diff) + 1);
                }else{
                    diffMap[j].put(diff,2);
                }
//                diffMap[j].put(diff, dp[j]);
                ans = Math.max(ans, dp[j]);
            }

        }
        return ans;
    }
}
