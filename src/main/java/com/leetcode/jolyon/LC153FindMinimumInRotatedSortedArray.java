package com.leetcode.jolyon;

public class LC153FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length==1) return nums[0];
            int lo=0, hi=nums.length;
            int N = nums.length;
            while(lo<hi){
                int mid = (lo+hi)/2;
                // As long as lo < hi, then nums[lo]>nums[hi]
                if(nums[mid]>nums[N-1]) lo =mid+1;
                else hi = mid;
            }
            return nums[lo];
        }
    }
}
