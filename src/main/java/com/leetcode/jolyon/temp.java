package com.leetcode.jolyon;

import java.util.*;

public class temp {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] w1, int[] w2)->{
            if (w1[0] == w2[0]) {
                return w1[1] - w2[1];
            } else {
                return w1[0] - w2[0];
            }
        });
        List<int[]>res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int next = i;
            while (next + 1 < intervals.length && intervals[next + 1][0] <= end) {
                end = Math.max(end, intervals[next][1]);
                next++;
            }
            res.add(new int[]{start, end});
            start = next;
        }
        return res.toArray(new int[1][1]);

    }
}
