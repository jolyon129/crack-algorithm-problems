package com.leetcode.jolyon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC315CountOfSmallerNumAfter {
    public List<Integer> countSmaller(int[] nums) {
        int[] idx = new int[nums.length];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        merge(0, nums.length, nums, idx, result);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
//        return new ArrayList<Integer>(new ArrayList<Integer>(Arrays.asList(result)));
    }

    private void merge(int lo, int hi, int[] nums, int[] idx, int[] result) {
        if (lo + 1 >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        merge(lo, mid, nums, idx, result);
        merge(mid, hi, nums, idx, result);
        int j = mid;
        int[] cache = new int[hi - lo];
        int k = 0;
//        Memorize!
        for(int i =lo; i< mid; i++){
            while (j<hi&&nums[idx[j]]<nums[idx[i]]){
                cache[k] = idx[j];
//                result[idx[i]]++;
                k++;
                j++;
            }
            result[idx[i]] += j - mid;
            cache[k] = idx[i];
            k++;
        }
//        int i = lo;
//        while (k < cache.length) {
//            while (j < hi &&i<mid&& nums[idx[j]] < nums[idx[i]]) {
//                cache[k] = idx[j];
//                k++;
//                j++;
//            }
//            result[idx[i]] = j - mid;
//            while (j < hi &&i<mid&& nums[idx[j]] >= nums[idx[i]]){
//                cache[k] = idx[i];
//                k++;
//                i++;
//            }
//
//        }
        /**
         *  Attention !!! n<j-lo!! not n< cache.size!
         */
        for(int n=0; n <j-lo; n++){
            idx[n+lo] = cache[n];
        }
    }

}
