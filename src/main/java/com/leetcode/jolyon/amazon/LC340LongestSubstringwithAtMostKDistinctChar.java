package com.leetcode.jolyon.amazon;

import java.util.HashMap;
import java.util.Map;

public class LC340LongestSubstringwithAtMostKDistinctChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n*k == 0) return 0;
        // sliding window left and right pointers
        int left = 0, right = 0;
        int max_len = 0;
        // char->freq
        Map<Character, Integer> map = new HashMap<>();
        while (right<s.length()){
            char cur = s.charAt(right);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // If window too big, we have to contract.
            while (left<right&&map.size()>k){
                char c = s.charAt(left);
                // Remove the leftmost one
                map.put(c, map.get(c) - 1);
                if(map.get(c)==0) map.remove(c);
                left++;
            }
            max_len = Math.max(max_len, right - left + 1);
            right++;
        }


        return max_len;
    }
}
