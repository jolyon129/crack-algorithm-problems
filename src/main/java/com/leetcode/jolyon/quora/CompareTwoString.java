package com.leetcode.jolyon.quora;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CompareTwoString {
    boolean solve(String a, String b) {
        Map<Character,Integer> freqMapA = new HashMap<>();
        Map<Character,Integer> freqMapB = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            freqMapA.put(a.charAt(i), freqMapA.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            freqMapB.put(b.charAt(i),
                    freqMapB.getOrDefault(b.charAt(i), 0) + 1);
        }
        if(!freqMapA.keySet().equals(freqMapB.keySet())) return false;
        Set<Integer> setA = new HashSet<>(freqMapA.values());
        Set<Integer> setB = new HashSet<>(freqMapB.values());
        return setA.equals(setB);
    }
}
