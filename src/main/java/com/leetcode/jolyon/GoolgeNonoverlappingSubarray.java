package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class GoolgeNonoverlappingSubarray {
    public int solve(int[] arr, int K){
        Map<Integer, Integer> leftSum = new HashMap<>();
        int N = arr.length;
        Integer[] leftMinItr = new Integer[N]; //include ith
        leftSum.put(0,-1);
        int cumSum = 0;
        int smallestLen = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            cumSum+=arr[i];
            leftSum.put(cumSum,i);
            if(leftSum.containsKey(cumSum-K)){
                int startIdx = leftSum.get(cumSum-K);
                smallestLen = Math.min(smallestLen, i-startIdx);
            }
            leftMinItr[i] = smallestLen;
        }
        if(smallestLen==Integer.MAX_VALUE) return -1;
        Integer[] rightMinItr = new Integer[N]; //include ith
        Map<Integer,Integer> rightSum = new HashMap<>();
        rightSum.put(0,N);
        smallestLen = Integer.MAX_VALUE;
        cumSum =0;
        for(int i=N-1;i>=0;i--){
            cumSum+=arr[i];
            if(rightSum.containsKey(cumSum-K)){
                int endingIdx = rightSum.get(cumSum-K);
                smallestLen = Math.min(endingIdx-i,smallestLen);
            }
            rightMinItr[i] = smallestLen;
        }
        int ans =Integer.MAX_VALUE;
        for(int i=1;i<N-1;i++){
            if(leftMinItr[i]==Integer.MAX_VALUE||rightMinItr[i+1]==Integer
            .MAX_VALUE) continue;
            int sum = leftMinItr[i]+rightMinItr[i+1];
            ans = Math.min(sum, ans);
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}
