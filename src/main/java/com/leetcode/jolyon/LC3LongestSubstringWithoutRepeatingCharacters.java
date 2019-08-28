package com.leetcode.jolyon;

import java.util.*;

public class LC3LongestSubstringWithoutRepeatingCharacters {
    static class O2NSOlution {
        public int lengthOfLongestSubstring(String s) {
            Deque<Character> window = new ArrayDeque<>();
            Set<Character> seen = new HashSet<>();
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!seen.contains(s.charAt(i))) {
                    seen.add(s.charAt(i));
                    window.add(s.charAt(i));
                    if (i == s.length() - 1) {
                        ans = Math.max(ans, window.size());
                    }
                } else {
                    ans = Math.max(ans, window.size());
                    while (window.peekFirst() != s.charAt(i)) {
                        seen.remove(window.peekFirst());
                        window.pollFirst();
                    }
                    window.pollFirst();
                    window.add(s.charAt(i));
                }
            }
            return ans;
        }

    }

    static class betterSolution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j))+1, i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j);
            }
            return ans;
        }
    }
}
