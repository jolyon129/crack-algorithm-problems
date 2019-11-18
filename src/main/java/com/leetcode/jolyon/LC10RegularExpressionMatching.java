package com.leetcode.jolyon;

public class LC10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // "a*" matches ""!
        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int idxS = i - 1;
                int idxP = j - 1;
                if (dp[i - 1][j - 1] && ((s.charAt(idxS) == p.charAt(idxP)) || p.charAt(idxP) == '.')) {
                    dp[i][j] = true;
                } else if (p.charAt(idxP) == '*') {
                    // If matches nothing
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else {
                        // If matches once
                        if (dp[i - 1][j] && (s.charAt(idxS) == p.charAt(idxP - 1) || p.charAt(idxP - 1) == '.')) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
