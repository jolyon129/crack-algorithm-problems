package com.leetcode.jolyon;

public class LC516LongestPalindromicSubsequence {
    public int longestPalindromeSubseqIterative(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for(int i=N-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j=i+1;j<N;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N-1];
    }
    public int longestPalindromeSubseqRecurssive(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    private int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }

}
