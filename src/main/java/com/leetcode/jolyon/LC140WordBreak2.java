package com.leetcode.jolyon;

import java.util.*;

public class LC140WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(0, s, wordSet, new HashMap<>());
    }

    public List<String> dfs(int start, String s, Set<String> wordSet,
                            Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);
        if (start == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        List<String> res = new ArrayList<>();
        for (int i = start + 1; i < s.length()+1; i++) {
            String temp = s.substring(start, i);
            if (wordSet.contains(temp)) {
                List<String> subres = dfs(start + temp.length(), s,
                        wordSet, memo);
                if (subres.size() != 0) {
                    for (String str : subres) {
                        if (str.isEmpty()) {
                            res.add(temp);
                        } else {
                            res.add(temp + " " + str);
                        }
                    }
                }
            }
        }
        memo.put(start, res);
        return res;
    }
}
