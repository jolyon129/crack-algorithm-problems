package com.leetcode.jolyon;

public class LC45JumpGameII {
    static class Solution {
        public int jump(int[] nums) {
            // Initially, only the first element in our "level"
            int curRightMost =0;
            int idx =0;
            int step =0;
            while(idx<nums.length){
                if(curRightMost>=nums.length-1)  break;
                int nextRightMost = 0;
                for(;idx<=curRightMost;idx++){
                    nextRightMost = Math.max(nextRightMost,idx+nums[idx]);
                }
                step++;
                curRightMost = nextRightMost;
            }
            return step;
        }

    }
}
