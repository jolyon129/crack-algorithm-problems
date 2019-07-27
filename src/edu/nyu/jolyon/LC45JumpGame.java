package edu.nyu.jolyon;

public class LC45JumpGame {
    static class Solution {
        public int jump(int[] nums) {
            int curRightmost =0;
            int i =0;
            int steps = 0;
            while(i<=nums.length-1){
                steps++;
                int nextRightmost = 0;
                for(;i<=curRightmost;i++){
                    if(nums[i]+i>=nums.length-1) return steps;
                    nextRightmost = Math.max(nextRightmost,nums[i]+i);
                }
                curRightmost = nextRightmost;
            }
            throw new AssertionError();
        }

    }
}
