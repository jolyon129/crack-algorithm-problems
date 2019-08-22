package com.leetcode.jolyon;

public class LC34FindandLastPositionofElementinSortedArray {
    static class teribbleSolution{
        public int[] searchRange(int[] nums, int target) {
            if(nums.length==0) return new int[]{-1,-1};
            if(nums.length==1){
                if(nums[0]==target) return new int[]{0,0};
                else return new int[]{-1,-1};
            }
            int l =0;
            int r = nums.length-1;
            int end = -1;
            int start = -1;
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid]==target){
                    if(mid==nums.length-1){
                        end = mid;
                        break;
                    }
                    if(nums[mid+1]!=target){
                        end = mid;
                        break;
                    }
                    else l=mid+1;
                }else if(nums[mid]>target){
                    r = mid-1;
                }else{
                    l = mid +1;
                }
            }
            if(end==-1) return new int[]{-1, -1};
            // Don't forget to reset the l and r!!
            l=0;
            r=nums.length-1;
            while(l<=r){
                int mid =(l+r)/2;
                if(nums[mid]==target){
                    if(mid==0) {
                        start = mid;
                        break;
                    }
                    if(nums[mid-1]!=target){
                        start = mid;
                        break;
                    }
                    else r=mid-1;
                }else if(nums[mid]>target){
                    r = mid-1;
                }else{
                    l = mid +1;
                }
            }
            return new int[]{start, end};
        }
    }
    static class Solution{
        public int[] searchRange(int[] nums, int target) {
            if(nums.length==0) return new int[]{-1,-1};
            int l =0;
            int r = nums.length-1;
            while(l<r){
                // Mid biased to the left one
                int mid = l+ (r-l)/2;
                if(nums[mid]<target){
                    // We have already checked the left one,
                    l = mid+1;
                }else{
                    // The mid could possible be the answer
                    r = mid;
                }
            }
            int start = r;
            if(nums[start]!=target) return new int[]{-1,-1};
            l=0;
            r = nums.length-1;
            while(l<r){
                int mid = l+ (r-l)/2+1;
                if(nums[mid]<target || nums[mid]==target){
                    l= mid;
                }
                else {
                    r= mid-1;
                }
            }
            int end = l;
            return new int[]{start, end};
        }
    }
}