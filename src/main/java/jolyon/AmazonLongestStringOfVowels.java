package com.leetcode.jolyon;

import java.util.*;

public class AmazonLongestStringOfVowels {
    public int longestStringOfVowels(String s) {
        int L = s.length();
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        List<Integer> consonants = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            if (!vowels.contains(s.charAt(i))) consonants.add(i);
        }
        int leftPart = 0;
        int rightPart = 0;
        int C = consonants.size();
        // if there is only 1 consonant
        if (C == 1) return L - 1;
        // if there is no consonant
        if(C==0) return L;
        // If leftPart has 0 consonant  and rightPart has all
        int count = L - (consonants.get(C - 1) - consonants.get(0)) - 1;

        for (int i = 0; i < consonants.size() - 1; i++) {
            leftPart = consonants.get(i) - consonants.get(0) + 1;
            rightPart = consonants.get(C - 1) - consonants.get(i + 1) + 1;
            if (L - (leftPart + rightPart) > count)
                count = L - (leftPart + rightPart);
        }
        return count;
    }
}
