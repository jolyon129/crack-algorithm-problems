package com.leetcode.jolyon;

public class LC55JumpGame {
    int idx = 0;

    public boolean canJump(int[] nums) {
        if(nums.length<2){
            return true;
        }
        idx = nums.length - 2;
        while (idx >= 0) {
            if (nums[idx] == 0) {
                if(!checkPrevious(idx, nums)){
                    return false;
                }
            }
            idx--;
        }
        return true;
    }

    private boolean checkPrevious(int i, int[] nums) {
        int t = i - 1;
        if(t<0){
            return false;
        }
        while (t>=0){
            if (nums[t] > i-t) {
                idx = t;
                return true;
            }
            t--;
        }
        return false;

    }
}
