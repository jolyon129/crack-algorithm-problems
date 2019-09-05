package com.leetcode.jolyon;

import java.util.*;

public class LC39CombintionSum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            Deque<Integer> temp = new ArrayDeque<>();
            backtrack(nums,temp,target,0,res);
            return res;
        }
        private void backtrack(int[] nums, Deque<Integer> temp, int target, int idx, List<List<Integer>> res){
            if(target==0) res.add(new ArrayList<Integer>(temp));
            else if(target<0) return;
            else{
                for(int i=idx;i<nums.length;i++){
                    temp.add(nums[i]);
                    backtrack(nums,temp,target-nums[i],i,res);
                    temp.pollLast();
                }
            }
        }
    }
}
