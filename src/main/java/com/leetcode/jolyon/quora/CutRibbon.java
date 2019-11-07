package com.leetcode.jolyon.quora;

//https://leetcode.com/discuss/interview-question/388503/Google-or-Phone-Screen-or-Cut-Ribbon/350993


public class CutRibbon {
    int solve(int[] ribbons, int target) {
        int hi = Integer.MIN_VALUE, lo = 1;
        for (int i = 0; i < ribbons.length; i++) {
            hi = Math.max(hi, ribbons[i]);
        }
        int ans = 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int r = helper(ribbons, mid);
            if (r < target) {
                hi = mid-1;
            } else {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            }
        }
        return ans;
    }

    int helper(int[] ribbons, int cut) {
        int count = 0;
        for (int i = 0; i < ribbons.length; i++) {
            count += ribbons[i] / cut;
        }
        return count;
    }
}
