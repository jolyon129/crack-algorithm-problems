package edu.nyu.jolyon;

import java.util.*;

public class LC416PartitionEqualSubsetSum {
    /**
     * This is totally wrong!
     * @param nums
     * @return
     */
    public boolean canPartitionWrong(int[] nums) {
        int[] prefix_sum = new int[nums.length+1];
        int target = 0;
        boolean[] dp= new boolean[nums.length];
        prefix_sum[0] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(prefix_sum[0]);
        for(int i =0;i<nums.length;i++){
            prefix_sum[i+1] = prefix_sum[i] + nums[i];
            set.add(prefix_sum[i+1]);
        }
        if(prefix_sum[prefix_sum.length-1]%2==1) return false;
        target = prefix_sum[prefix_sum.length-1]/2;
        dp[0] = prefix_sum[1]==target;
        for(int i=1; i<nums.length;i++){
            if(prefix_sum[i+1]<target) dp[i]=false;
            else if(prefix_sum[i+1]==target) dp[i]=true;
            else{
                dp[i] = dp[i-1]||set.contains(prefix_sum[i+1]-target);
            }
        }
        return dp[dp.length-1];
    }

    public boolean canPartion(int[] nums){
        return true;
    }
}
