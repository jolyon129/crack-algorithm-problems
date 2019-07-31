package edu.nyu.jolyon;

public class LC540SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int lo=0, hi=nums.length-1;
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length - 1];
        while (lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]!=nums[mid-1]&&nums[mid]!=nums[mid+1]) return nums[mid];
            else if(mid%2==0 &&nums[mid]==nums[mid-1]) hi = mid-1;
            else if(mid%2==1 && nums[mid]==nums[mid+1]) hi = mid-1;
            else{
                lo = mid+1;
            }
        }
        throw new AssertionError();
    }
}
