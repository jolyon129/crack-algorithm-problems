package com.leetcode.jolyon;

import java.util.Arrays;

public class LC621TaskScheduler {
    public static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char c : tasks)
                map[c - 'A']++;
            Arrays.sort(map);
            int nBins = map[25] - 1, leaseIdleSlots = nBins * n;
            for (int i = 24; i >= 0 && map[i] > 0; i--) {
                // If there are server letters with the same max frequency,
                // we just need maxFreq-1 items to fill the maxFreq-1 bins
                leaseIdleSlots -= Math.min(map[i], nBins);
            }
            return leaseIdleSlots > 0 ? leaseIdleSlots + tasks.length : tasks.length;
        }
    }
}
