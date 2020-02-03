package com.leetcode.jolyon.impact;

import java.util.HashSet;
import java.util.Set;

public class CompleteString {
    /**
     * The solution takes O(n) time and constant space.
     *
     * @param str input
     * @return return whether the input is a complete string.
     */
    static boolean isCompleteString(String str) {
        if (str.length() < 26) return false;
        Set<Character> set = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (set.contains(c)) continue;
            if (c - 'A' >= 0 && c - 'A' < 26) {
                set.add(c);
            }
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(isCompleteString("ABCDEFGHIJKLMNOPQRSTUVWXYZZZZ"));
        System.out.println(isCompleteString("ABCDEFGHIJKLMNOPQRSTUVWXY"));
    }
}
