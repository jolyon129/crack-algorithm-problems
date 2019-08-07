package com.leetcode.jolyon;

public class LC33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length==1) return nums[0]==target?0:-1;
        int i = searchRotateIndex(nums);
        if(nums[i]==target) return i;
        int left=0, right=nums.length-1;
        if(nums[nums.length-1]==target) return nums.length-1;
        if(nums[nums.length-1]<target){
            right = i-1;
        }else if(nums[nums.length-1]>target){
            left = i;
        }
        while(left<=right){
            int mid = (right-left)/2 +left;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) right = mid-1;
            else if(nums[mid]<target) left = mid+1;
        }
        return -1;
    }
    private int searchRotateIndex(int[] nums){
        int lo=0, hi=nums.length-1;
        while(lo<hi){
            int mid = (hi-lo)/2 + lo;
            if(nums[mid]>nums[hi]) lo= mid+1;
            else hi=mid;
        }
        return lo;
    }
}
