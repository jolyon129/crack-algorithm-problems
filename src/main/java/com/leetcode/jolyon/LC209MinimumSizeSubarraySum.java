package com.leetcode.jolyon;

public class LC209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, left = 0, win = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                win = Math.min(win, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }
}
