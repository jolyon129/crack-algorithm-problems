package com.leetcode.jolyon.bloomberg;

public class LC53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int prefixSum  = 0;
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            prefixSum = Math.max(prefixSum+nums[i],nums[i]);
            ans = Math.max(ans, prefixSum);
        }
        return ans;
    }
    class DivideAndConquer {
        public int crossSum(int[] nums, int left, int right, int mid) {
            if (left == right) return nums[left];
            // the max sum of substring starting from mid towards to left.
            int leftSubsum = Integer.MIN_VALUE;
            int currSum = 0;
            for(int i = mid; i >= left; --i) {
                currSum += nums[i];
                leftSubsum = Math.max(leftSubsum, currSum);
            }

            int rightSubsum = Integer.MIN_VALUE;
            currSum = 0;
            for(int i = mid + 1; i <= right; ++i) {
                currSum += nums[i];
                rightSubsum = Math.max(rightSubsum, currSum);
            }

            return leftSubsum + rightSubsum;
        }
        // return the max subarray.
        // "right" is inclusive!
        public int helper(int[] nums, int left, int right) {
            if (left == right) return nums[left];

            int mid = (left + right) / 2;

            int leftSum = helper(nums, left, mid);
            int rightSum = helper(nums, mid + 1, right);
            int crossSum = crossSum(nums, left, right, mid);

            return Math.max(Math.max(leftSum, rightSum), crossSum);
        }

        public int maxSubArray(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
    }
}
