package com.leetcode.jolyon;

public class LC31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;
        int idx1= nums.length-2;
        for(;idx1>=0;idx1--){
            if(nums[idx1]<nums[idx1+1]) break;
        }
        if(idx1!=-1){
            int idx2 = idx1+1;
            for(;idx2<nums.length;idx2++){
                if(idx2==nums.length-1||(nums[idx2+1]<=nums[idx1]&&nums[idx2]>nums[idx1])){
                    swap(idx1,idx2,nums);
                    break;
                }
            }
        }
        int left = idx1+1;
        int right = nums.length-1;
        while(left<right){
            swap(left,right,nums);
            left++;
            right--;
        }

    }
    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] =nums[j];
        nums[j] = tmp;
    }
}
