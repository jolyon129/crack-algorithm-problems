package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class FactualOA2 {
    public long solution(long[][] clients) {
        long xSum = 0, ySum = 0;
        long N = clients.length;
        for (int i = 0; i < clients.length; i++) {
            xSum += clients[i][0];
            ySum += clients[i][1];
        }
        double newX = (double) xSum / N;
        double newY = (double) ySum / N;
        List<long[]> candidates = new ArrayList<>();
        candidates.add(new long[]{(long) Math.ceil(newX), (long) Math.ceil(newY)});
        candidates.add(new long[]{(long) Math.ceil(newX), (long) Math.floor(newY)});
        candidates.add(new long[]{(long) Math.floor(newX), (long) Math.ceil(newY)});
        candidates.add(new long[]{(long) Math.floor(newX), (long) Math.floor(newY)});
        long res = Long.MAX_VALUE;
        for (int n = 0; n < candidates.size(); n++) {
            long sum = 0;
            for (int i = 0; i < clients.length; i++) {
                sum += distance(candidates.get(n), clients[i]);
            }
            res = Math.min(res, sum);
        }
        return res;
    }

    private long distance(long[] point1, long[] point2) {
        return Math.abs(point1[1] - point2[1]) + Math.abs(point1[0] - point2[0]);
    }

}
