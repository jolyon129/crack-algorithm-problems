package com.leetcode.jolyon;

import java.util.List;

public class TwitterGetSetGo {
    public static boolean isPossible(List<Integer> calCounts, int requiredCals) {
        Boolean[][] dp = new Boolean[calCounts.size() + 1][requiredCals + 1];
        dp[0][0] = true;
        for (int i = 0; i <= calCounts.size(); i++) {
            for (int j = 0; j <= requiredCals; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (j!=0&&i==0) {
                    dp[i][j] = false;
                } else {
                    if (calCounts.get(i - 1) > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - calCounts.get(i - 1)] || dp[i - 1][j];
                    }
                }

            }
        }
        return dp[calCounts.size()][requiredCals];
    }
}
