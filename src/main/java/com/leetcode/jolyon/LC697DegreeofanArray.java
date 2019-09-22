package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC697DegreeofanArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> leftMostIdx = new HashMap<>();
        int maxFreq = 0;
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
            int count = freq.get(nums[i]);
            maxFreq = Math.max(count, maxFreq);
            if(!leftMostIdx.containsKey(nums[i])){
                leftMostIdx.put(nums[i],i);
            }
        }
        if(maxFreq == 1){
            return 1;
        }
        for(int i=nums.length-1;i>=0;i--){
            if(freq.get(nums[i])==maxFreq){
                ans = Math.min(i-leftMostIdx.get(nums[i])+1,ans);
                freq.put(nums[i], -1);
            }
        }
        return ans;
    }
}
