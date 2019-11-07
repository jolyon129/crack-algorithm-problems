package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        backtrack(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if (pos == s.length()) {
            // Make a copy of the current path
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                backtrack(res, path, dp, s, i + 1);
                // remove the last one.
                path.remove(path.size() - 1);
            }
        }
    }

}
