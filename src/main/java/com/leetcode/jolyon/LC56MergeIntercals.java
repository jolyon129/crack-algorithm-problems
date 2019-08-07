package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;

public class LC56MergeIntercals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (w1, w2) -> w1[0] - w2[0]);
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0, j = 1;
        int lower, upper;
        if(intervals.length<=1){
            return intervals;
        }
        while (i < intervals.length) {
            lower = intervals[i][0];
            upper = intervals[i][1];
            if (i == intervals.length - 1) result.add(new int[]{lower, upper});
            else {
                while (j < intervals.length && upper >= intervals[j][0]) {
                    upper = Math.max(upper, intervals[j][1]);
                    j++;
                }
                result.add(new int[]{lower, upper});
            }
            i = j;
            j += 1;
        }
        return result.toArray(new int[result.size()][]);
    }
}
