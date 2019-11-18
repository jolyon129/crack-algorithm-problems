package com.leetcode.jolyon.amazon;

import java.util.TreeSet;

public class LC264UglyNumberII {
    class Solution{

        public int nthUglyNumber(int n) {
            // dp[n] = min(dp[i2]*2,dp[i3]*3,dp[i5]*5);

            if (n == 1) return 1;
            int[] ugly = new int[n + 1];

            ugly[1] = 1;
            int index2 = 1, index3 = 1, index5 = 1;
            for (int i = 2; i <= n; i++) {
                int candidate2 = ugly[index2] * 2, candidate3 = ugly[index3] * 3, candidate5 = ugly[index5] * 5;
                int min = Math.min(Math.min(candidate2, candidate3),
                        candidate5);
                ugly[i] = min;
                // Cannot use elseif! avoid duplicates!
                if (candidate2 == min)
                    index2++;
                if (candidate3 == min)
                    index3++;
                if (candidate5 == min)
                    index5++;
            }
            return ugly[n];
        }
    }
    class SolutionPQ{
        public int nthUglyNumber(int n) {
            TreeSet<Long> ans = new TreeSet<>();
            ans.add(1L);
            for (int i = 0; i < n - 1; ++i) {
                long first = ans.pollFirst();
                ans.add(first * 2);
                ans.add(first * 3);
                ans.add(first * 5);
            }
            return ans.first().intValue();
        }
    }
}
