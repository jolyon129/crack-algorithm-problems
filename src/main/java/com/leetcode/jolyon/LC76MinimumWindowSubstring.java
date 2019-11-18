package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC76MinimumWindowSubstring {
    // t could contains duplicates
    public String minWindow(String s, String t) {
        // Map: char-> how many do we need to satisfy the target
        // If its negative, means we have surplus for that character
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, minStart = -1, minEnd = s.length();
        // how many chars do we need to find.
        int counter = t.length();
        while (end < s.length()) {
            char cur = s.charAt(end);
            // If the cur is one of the target
            if (map.containsKey(cur)){
                if(map.get(cur)>0){
                    // if we have not found enough number of this character,
                    // then we need to use this character.
                    counter--;
                }
                map.put(cur, map.get(cur) - 1);
            }

            // If we've already found all the targets, then try to contract the
            // window
            while (start<s.length()&&counter == 0) {
                if (minEnd-minStart > end - start) {
                    minEnd = end;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                if(map.containsKey(c2)){
                    map.put(c2, map.get(c2) + 1);
                    // If after we moving the start, we are lack of the c2, then
                    if (map.get(c2) > 0) counter++;
                }

                start++;
            }
            end++;
        }
        if(minStart==-1) return "";
        return s.substring(minStart, minEnd+1);
    }}