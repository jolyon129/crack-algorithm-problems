package com.leetcode.jolyon.bloomberg;

public class LC5LongestPalindromicSubstring {
    int left = 0;
    int right = 0;

    // dp[i][j]= dp[i+1][j-1] && s[i]==s[j]
    public String longestPalindromeDp(String s) {
        if (s.equals("")) return "";
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int left = 0, right = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1) dp[i][j] = true;
                    else if (i + 1 < N && j - 1 > 0 && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                // Keep tracking of the longest window
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l > right - left) {
                right = r;
                left = l;
            }
            l--;
            r++;

        }

    }
}
