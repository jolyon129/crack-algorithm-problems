package com.leetcode.jolyon;

import java.util.Arrays;

public class LC16_3SumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(target-ans);
        for(int i=0;i<nums.length;i++){
            if(i>=1&&nums[i]==nums[i-1]) continue;
            int sum = target-nums[i];
            int h = i+1;
            int t = nums.length-1;
            while(h<t){
                if(Math.abs(nums[h]+nums[t]+nums[i]-target) < diff){
                    ans = nums[h]+nums[t]+nums[i];
                    diff = Math.abs(nums[h]+nums[t]+nums[i]-target);
                }

                if(nums[h]+nums[t]<sum){
                    h++;
                }else if(nums[h]+nums[t]>sum){
                    t--;
                }else{
                    return target;
                }


            }
        }
        return ans;
    }
}
