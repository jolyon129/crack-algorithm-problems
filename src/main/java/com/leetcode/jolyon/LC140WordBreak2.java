package com.leetcode.jolyon;

import java.util.*;

public class LC140WordBreak2 {
    class RecursiveSolution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            return recur(0, s, wordSet, new HashMap<>());
        }

        public List<String> recur(int start, String s, Set<String> wordSet,
                                  Map<Integer, List<String>> memo) {
            if (memo.containsKey(start)) return memo.get(start);
//        if (start == s.length()) {
//            List<String> res = new ArrayList<>();
//            res.add("");
//            return res;
//        }
            List<String> res = new ArrayList<>();
            for (int i = start + 1; i < s.length() + 1; i++) {
                String curStr = s.substring(start, i);
                if (wordSet.contains(curStr)) {
                    if (i == s.length()) {
                        res.add(curStr);
                        return res;
                    }
                    List<String> subPath = recur(start + curStr.length(), s,
                            wordSet, memo);
                    if (subPath.size() != 0) {
                        for (String str : subPath) {
                            res.add(curStr + " " + str);
                        }
                    }
                }
            }
            memo.put(start, res);
            return res;
        }
    }

    class IterativeSolution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);

            // Check if there is at least one possible sentence
            boolean[] dp1 = new boolean[s.length() + 1];
            dp1[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp1[j] && wordSet.contains(s.substring(j, i))) {
                        dp1[i] = true;
                        break;
                    }
                }
            }

            // We are done if there isn't a valid sentence at all
            if (!dp1[s.length()]) {
                return new ArrayList<String>();
            }

            // Build the results with dynamic programming
            ArrayList<String>[] dp = new ArrayList[s.length() + 1];
            ArrayList<String> initial = new ArrayList<>();
            initial.add("");
            dp[0] = initial;
            for (int i = 1; i <= s.length(); i++) {
                ArrayList<String> list = new ArrayList<>();
                for (int j = i-1; j >=0; j--) {
                    String curWord = s.substring(j, i);
                    if (dp[j].size() > 0 && wordSet.contains(curWord)) {
                        for (String l : dp[j]) {
                            list.add(l + (l.equals("") ? "" : " ") + curWord);
                        }
                    }
                }
                dp[i] = list;
            }
            return dp[s.length()];
        }
    }
}
