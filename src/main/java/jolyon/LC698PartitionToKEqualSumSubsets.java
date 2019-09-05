package com.leetcode.jolyon;

public class LC698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] groups = new int[k];
        if (backtrack(nums, 0, groups, target)) return true;
        else return false;
    }

    private boolean backtrack(int[] nums, int start, int[] groups, int sum) {
        if(start>=nums.length) return true;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + nums[start] <= sum){
                groups[i] +=nums[start];
                if(backtrack(nums, start + 1, groups, sum)) return true;
                groups[i] -=nums[start];
            }
            // This is a very good way to speed up the searching.
            // Actually, we just need to do 1 recursion on each loop.
            if (groups[i] == 0) break;

        }
        return false;
    }
}
