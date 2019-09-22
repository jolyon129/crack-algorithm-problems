package com.leetcode.jolyon;

public class LC1191KConcatenationMaxSum {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long suffixSum =0;
        long sum = 0;
        // store the maxSum of k =1;
        long maxSum1 = 0;
        long prefixSum = 0;
        long M = 1_000_000_000 + 7;
        long ans;
        for(int i=0;i<arr.length;i++){
            sum += arr[i]%M;
            prefixSum = Math.max(arr[i], (prefixSum + arr[i])% M)% M;
            maxSum1 = Math.max(maxSum1, prefixSum);
            int j = arr.length - 1-i;
            suffixSum = Math.max(arr[j], (suffixSum + arr[j])% M)% M;
        }
        if (sum > 0) {
            if(k>2){
                ans = Math.max(maxSum1,
                        (prefixSum + (k - 2) * sum % M + suffixSum) % M);
            }else{
                ans = Math.max(maxSum1, (prefixSum + suffixSum) % M);
            }
        }else{
            ans = Math.max(maxSum1, (prefixSum + suffixSum)% M)% M;
        }
        return (int) ans;
    }
}
