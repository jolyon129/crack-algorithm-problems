package com.leetcode.jolyon;

public class LC81SearchInRotatedSortedArray2 {
    static class solution {
        public boolean search(int[] nums, int target) {
            if (nums.length == 0) return false;
            if (nums.length == 1) return nums[0] == target ? true : false;
            int i = searchRotateIndex(nums);
            if (nums[i] == target) return true;
            int left = 0, right = nums.length - 1;
            if (nums[nums.length - 1] == target) return true;
            if (nums[nums.length - 1] < target) {
                right = i - 1;
            } else if (nums[nums.length - 1] > target) {
                left = i;
            }
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) return true;
                else if (nums[mid] > target) right = mid - 1;
                else if (nums[mid] < target) left = mid + 1;
            }
            return false;
        }

        private int searchRotateIndex(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                while (lo < hi && nums[lo] == nums[hi]) {
                    lo++;
                }
                int mid = (hi - lo) / 2 + lo;
                if (nums[mid] > nums[hi]) lo = mid + 1;
                else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
    static class ConciseSolution{
        public boolean search(int[] nums, int target) {
            if(nums.length==0) return false;
            int l =0;
            int r = nums.length-1;
            while(l<r){
                if(nums[l]==target) return true;
                while(l<r&&nums[l]==nums[r]){
                    l++;
                }
                int mid = (r-l)/2+l;
                if(nums[mid]==target) return true;
                if(nums[mid]>nums[r]){ // If mid is on the left
                    if(target<=nums[nums.length-1]){ // If target is on the right
                        l = mid+1;
                    }else{// If target is on the left
                        if(nums[mid]<target){
                            l= mid+1;
                        }else{
                            r = mid;
                        }
                    }
                }else{// If mid is on the right
                    if(target>nums[r]){ // If target is on the left
                        r=mid;
                    }else{ // if target is on the right
                        if(nums[mid]<target){
                            l =mid+1;
                        }else{
                            r = mid;
                        }
                    }
                }
            }
            if(l==r&&nums[r]==target) return true;
            return false;
        }
    }
}
