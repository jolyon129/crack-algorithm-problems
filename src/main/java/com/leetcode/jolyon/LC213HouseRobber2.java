package com.leetcode.jolyon;

public class LC213HouseRobber2 {
    public int robHelper(int[] nums, int lo, int hi) {
        int ans = 0;
        int prev2 = nums[lo];
        int prev1 = Math.max(nums[lo + 1], nums[lo]);

        for (int i = lo + 2; i < hi; i++) {
            ans = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = 0;
        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                ans = Math.max(ans, nums[i]);
            }
            return ans;
        }
        return Math.max(robHelper(nums, 0, nums.length - 1), robHelper(nums, 1,
                nums.length));
    }
}
