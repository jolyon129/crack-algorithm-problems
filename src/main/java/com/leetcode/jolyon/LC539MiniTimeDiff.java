package com.leetcode.jolyon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC539MiniTimeDiff {
    public int findMinDifference(List<String> timePoints) {
        int MAXTIMEPOINT = 24 * 60;
        Set<Integer> buckets = new HashSet<>();
        for (String timepoint : timePoints) {
            String[] interval = timepoint.split(":");
            int h = Integer.parseInt(interval[0]);
            int m = Integer.parseInt(interval[1]);
            if (buckets.contains(h * 60 + m)) return 0;
            buckets.add(h * 60 + m);
        }
        int first=-1, last=-1, prev=-1, current=-1;
        int minDiff = MAXTIMEPOINT;
        for (int i = 0; i < MAXTIMEPOINT; i++) {
            if (buckets.contains(i)) {
                if (prev == -1) {
                    first = i;
                    prev = i;
                } else {
                    current = i;
                    last = i;
                    minDiff = Math.min(current - prev, minDiff);
                    prev = i;
                }
            }
        }
        int corner = first + (MAXTIMEPOINT - last);
        minDiff = Math.min(minDiff, corner);
        return minDiff;
    }
}
