package com.leetcode.jolyon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1239MaximumLengthofaConcatenatedStringwithUniqueCharacters {
    int ans = 0;
    public int maxLength(List<String> arr) {
        Set<Character> curPath = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            if (isUniq(arr.get(i))) {
                backtrack(arr, curPath, i);
            }
        }
        return ans;
    }

    public void backtrack(List<String> arr, Set<Character> curPath, int idx) {
        String str = arr.get(idx);
        boolean isValid = true;
        for (char c : str.toCharArray()) {
            if (curPath.contains(c)) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            for (char c : str.toCharArray()) curPath.add(c);
            ans = Math.max(ans, curPath.size());
            for (int j = idx + 1; j < arr.size(); j++) {
                if (isUniq(arr.get(j))) {
                    backtrack(arr, curPath, j);
                }
            }
            // backtrack
            for (char c : str.toCharArray()) curPath.remove(c);
        }

    }

    boolean isUniq(String str) {
        boolean[] table = new boolean[26];
        for (char c : str.toCharArray()) {
            if (table[c - 'a']) return false;
            else table[c - 'a'] = true;
        }
        return true;
    }
}
