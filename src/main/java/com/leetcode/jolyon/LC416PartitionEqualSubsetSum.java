package com.leetcode.jolyon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC416PartitionEqualSubsetSum {
    /**
     * This is totally wrong!
     *
     * @param nums
     * @return
     */
    public boolean canPartitionWrong(int[] nums) {
        int[] prefix_sum = new int[nums.length + 1];
        int target = 0;
        boolean[] dp = new boolean[nums.length];
        prefix_sum[0] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(prefix_sum[0]);
        for (int i = 0; i < nums.length; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + nums[i];
            set.add(prefix_sum[i + 1]);
        }
        if (prefix_sum[prefix_sum.length - 1] % 2 == 1) return false;
        target = prefix_sum[prefix_sum.length - 1] / 2;
        dp[0] = prefix_sum[1] == target;
        for (int i = 1; i < nums.length; i++) {
            if (prefix_sum[i + 1] < target) dp[i] = false;
            else if (prefix_sum[i + 1] == target) dp[i] = true;
            else {
                dp[i] = dp[i - 1] || set.contains(prefix_sum[i + 1] - target);
            }
        }
        return dp[dp.length - 1];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[n][sum];
    }
}
