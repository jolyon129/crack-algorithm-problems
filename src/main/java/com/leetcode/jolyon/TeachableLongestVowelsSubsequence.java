package com.leetcode.jolyon;

//https://www.hackerearth.com/problem/algorithm/fun-with-vowels/description/

public class TeachableLongestVowelsSubsequence {
    public int longestVowelSubsequence(String str) {
        String vowels = "aeiou";
        int N = str.length();
        Integer[][] dp = new Integer[N + 1][5 + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < 6; j++) {
                if (vowels.charAt(j - 1) == str.charAt(i - 1)) {
                    // 'aei' and 'aeiou'
                    if (j == 1 || (j > 1 && dp[i][j - 1] > 0)) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][5];
    }
}
