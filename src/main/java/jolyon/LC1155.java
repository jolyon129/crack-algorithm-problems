package com.leetcode.jolyon;

public class LC1155 {
    static class Solution{
        Long [][] dp;
        public int numRollsToTarget(int turns, int f, int target) {
            dp = new Long[turns+1][target+1];
            return (int) dp(turns, f, target);
        }

        private long dp(int turns, int f, int target){
            if (target < turns || target > turns * f) {
                return 0;
            }
            if(turns == 1 && target <= f)
                return 1;
            if(dp[turns][target] != null)
                return dp[turns][target];
            long result = 0;
            for(int i = 1; i <= f; i++){
                if (turns - 1 > 0 && target - i > 0) {
                    long temp =  (dp(turns -1, f, target - i)) %1000000007;
                    result += temp;
                    result = result % 1000000007;
                }
            }
            dp[turns][target] = result;
            return result;
        }
    }
}
