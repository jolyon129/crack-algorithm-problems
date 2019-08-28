package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for (int i = 0, j = 1; i < s.length()-1; i++, j++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(j))) {
                ans += map.get(s.charAt(i));
            } else {
                ans -= map.get(s.charAt(i));
            }
        }
        ans += map.get(s.charAt(s.length() - 1));
        return ans;
    }

}
