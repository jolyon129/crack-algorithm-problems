package edu.nyu.jolyon;

import java.util.HashMap;

/**
 * LC_550
 */
class LC560SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        int sum = 0;
        int count = 0;
        // Remeber to add (0,1)!!
        hashMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hashMap.containsKey(sum-k)){
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}