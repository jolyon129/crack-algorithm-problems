package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class LC523ContinusousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0]= 0;
        Map<Integer, Integer> map = new HashMap<>();
        // In order to deal with edge case
        map.put(0,-1);
        for(int i=0; i< nums.length;i++){
            prefixSum[i+1] = prefixSum[i]+nums[i];
            int r = k==0?prefixSum[i+1]:prefixSum[i+1]%k;
            if(map.containsKey(r)){
                if(i-map.get(r)>=2){
                    return true;
                }
            }else{
                map.put(r, i);
            }
        }
        return false;
    }
}
