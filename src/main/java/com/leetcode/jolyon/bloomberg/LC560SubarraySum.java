package com.leetcode.jolyon.bloomberg;

import java.util.HashMap;

/**
 * LC_560
 * We cannot use sliding window since the integer could be negative
 * Use freqMap and dynamically maintain this map from left to right, using one pass!
 */
class LC560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap();
        int sum = 0;
        int count = 0;
        // Remeber to add (0,1)!!
        freqMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(freqMap.containsKey(sum-k)){
                count += freqMap.get(sum - k);
            }
            freqMap.put(sum, freqMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}