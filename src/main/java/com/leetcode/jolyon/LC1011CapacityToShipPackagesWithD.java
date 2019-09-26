package com.leetcode.jolyon;

public class LC1011CapacityToShipPackagesWithD {
    public int shipWithinDays(int[] weights, int D) {
        int lo=0, hi=0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }
        int mid;
        while (lo <= hi) {
            mid = (hi - lo) / 2 + lo;
            int d = simulate(mid, weights, D);
            if(d<=D){
                hi = mid-1;
            }else{
                lo = mid + 1;
            }
        }
        // We're trying to find the least number, which means that the answer
        // prefers the left one.
        return lo;
    }

    int simulate(int capacity, int[] weights, int D) {
        int day =0;
        int curSum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (capacity < weights[i]) {
                return Integer.MAX_VALUE;
            }
            if (i == 0){
                curSum = weights[0];
                day = 1;
            }
            else {
                if (curSum + weights[i] <= capacity) {
                    curSum += weights[i];
                } else {
                    curSum = weights[i];
                    day++;
                }
            }
        }
        return day;
    }
}
