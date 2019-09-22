package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC1189MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 0);
        freq.put('b', 0);
        freq.put('l', 0);
        freq.put('o', 0);
        freq.put('n', 0);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b' || text.charAt(i) == 'a' || text.charAt(i) == 'l' || text.charAt(i) == 'o' || text.charAt(i) == 'n') {
                freq.put(text.charAt(i), freq.getOrDefault(text.charAt(i), 0) + 1);
            }
        }

        int ans = text.length();
        for (Character key : freq.keySet()) {
            if (key == 'l' || key == 'o') {
                ans = Math.min(freq.get(key) / 2, ans);
            } else {
                ans = Math.min(freq.get(key), ans);
            }
        }
        return ans;
    }
}


