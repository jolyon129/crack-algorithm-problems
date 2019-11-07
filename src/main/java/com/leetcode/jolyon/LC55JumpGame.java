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
                if(!checkPrevious(nums)){
                    return false;
                }
            }
            idx--;
        }
        return true;
    }

    private boolean checkPrevious(int[] nums) {
        int t = idx - 1;
        while (t>=0){
            if (nums[t] > idx-t) {
                idx = t;
                return true;
            }
            t--;
        }
        return false;

    }
}
