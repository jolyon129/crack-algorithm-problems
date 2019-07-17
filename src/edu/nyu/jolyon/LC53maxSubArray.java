package edu.nyu.jolyon;

/**
 * 53
 */
class LC53maxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = nums[0];
        int ending_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ending_sum = Math.max(ending_sum + nums[i], nums[i]);
            ans = Math.max(ending_sum, ans);
        }
        return ans;
    }
}