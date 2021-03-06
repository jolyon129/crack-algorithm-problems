package com.leetcode.jolyon;

public class LC287FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast=0, slow=0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        slow=0;
        while(slow!=fast){
            // simulate = slow;
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
