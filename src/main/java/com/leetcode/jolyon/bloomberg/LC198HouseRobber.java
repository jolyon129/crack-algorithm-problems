package com.leetcode.jolyon.bloomberg;

public class LC198HouseRobber {
    public int rob(int[] nums) {
        int ans = 0;
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                ans = Math.max(ans, nums[i]);
            }
            return ans;
        }
        // dp[n] = Math.max(dp[n-1],dp[n-2]+nums[n])
        // dp[i] stands for the max profit we can get ending at i;
        int prev2 = nums[0];
        int prev1 = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
