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
            // store the position where the char last occur.
            Map<Character, Integer> charToIdx = new HashMap<>();
            int left =-1;
            int ans =0;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(charToIdx.containsKey(c)){
                    left = Math.max(left,charToIdx.get(c));
                }
                charToIdx.put(c,i);
                ans = Math.max(ans,i-left);
            }
            return ans;
        }
    }
}
