package com.leetcode.jolyon;

public class LC28ImplmentStr {
    static class MyBadSolution {
        public int strStr(String haystack, String needle) {
            if (needle.equals("")) {
                return 0;
            }
            int ans = -1;
            int i = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int j = 0;
                    int start = i;
                    boolean found = true;
                    while (j < needle.length()) {
                        if (i >= haystack.length() || haystack.charAt(i) != needle.charAt(j)) {
                            j = needle.length();
                            found = false;
                        }
                        j++;
                        i++;
                    }
                    if (found) {
                        ans = start;
                        break;
                    } else {
                        i = start;
                    }
                }
                i++;
            }
            return ans;
        }
    }

    static class OMNSolution {
        public int strStr(String s, String t) {
            if (t.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
            for (int i = 0; i <= s.length() - t.length(); i++) {
                for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                    if (j == t.length() - 1) return i;
            }
            return -1;
        }

    }

    static class KMPSolution {
        public int strStr(String haystack, String needle) {
            int M = needle.length();
            int N = haystack.length();
            if (M == 0) return 0;
            if (N == 0) return -1;
            int[] lps = createLps(needle.toCharArray());
            int i = 0;
            int j = 0;
            while (i < N) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == M) return i - j;
                } else {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lps[j - 1];
                    }
                }
            }
            return -1;

        }

        public int[] createLps(char[] arr) {
            int[] lps = new int[arr.length];
            int prevMatchingLen = 0;
            lps[0] = 0;
            int idx = 1;
            while (idx < arr.length) {
                if (arr[idx] == arr[prevMatchingLen]) {
                    prevMatchingLen++;
                    lps[idx] = prevMatchingLen;
                    idx++;
                } else {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (prevMatchingLen != 0) {
                        prevMatchingLen = lps[prevMatchingLen - 1];
                    } else {
                        lps[idx] = 0;
                        prevMatchingLen = 0;
                        idx++;
                    }
                }
            }
            return lps;
        }
    }
}
