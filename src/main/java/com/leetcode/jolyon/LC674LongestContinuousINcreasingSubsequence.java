package com.leetcode.jolyon;

public class LC674LongestContinuousINcreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int N = nums.length;
        if(N==0) return 0;
        int[] dp = new int[N];
        dp[0]=1;
        int ans = dp[0];
        for(int i=1;i<N;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1] +1;
            }else{
                dp[i] = 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
