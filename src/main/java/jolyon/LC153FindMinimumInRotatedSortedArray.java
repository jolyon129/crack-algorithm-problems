package com.leetcode.jolyon;

public class LC153FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length==1) return 0;
            int lo=0, hi=nums.length-1;
            while(lo<hi){
                int mid = (lo+hi)/2;
                // As long as lo < hi, then nums[lo]>nums[hi]
                if(nums[mid]>nums[hi]) lo =mid+1;
                else hi = mid;
            }
            return nums[lo];
        }
    }
}
