package com.leetcode.jolyon;

public class LC152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int prefixMax = nums[0];
        int prefixMin = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp = Math.max(dp, nums[i]);
                dp = Math.max(dp, prefixMax * nums[i]);
                prefixMax = Math.max(prefixMax * nums[i], nums[i]);
                prefixMin = Math.min(prefixMin * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                dp = Math.max(dp, prefixMax);
                dp = Math.max(dp, prefixMin * nums[i]);
                int tmp = prefixMax;
                prefixMax = Math.max(prefixMin * nums[i], nums[i]);
                prefixMin = Math.min(tmp * nums[i], nums[i]);
            } else {
                dp = Math.max(dp, 0);
                prefixMax = 0;
                prefixMin = 0;
            }
        }
        return dp;

    }}
