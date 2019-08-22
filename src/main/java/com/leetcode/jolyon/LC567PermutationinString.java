package com.leetcode.jolyon;

public class LC567PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            h1[s1.charAt(i) - 'a']++;
            h2[s2.charAt(i) - 'a']++;
        }
        int len = s1.length();
        // The Upper bound of i should be added by 1 !
        for (int i = 0; i < s2.length() - len+1; i++) {
            if (i == 0) {
                if (validate(h1, h2)) return true;
            } else {
                h2[s2.charAt(i - 1) - 'a']--;
                h2[s2.charAt(i + len - 1) - 'a']++;
                if (validate(h1, h2)) return true;
            }
        }
        return false;
    }

    private boolean validate(int[] h1, int[] h2) {
        for (int i = 0; i < 26; i++) {
            if (h1[i] != h2[i]) {
                return false;
            }
        }
        return true;
    }
}
