package com.leetcode.jolyon;

import java.util.*;

public class LC47Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        recur(path,res,nums,used);
        return res;
    }
    private void recur(List<Integer> path, List<List<Integer>> res,int[] nums, boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            else{
                if(i!=0&&!used[i-1]&&nums[i]==nums[i-1]) continue;
                else{
                    path.add(nums[i]);
                    used[i] = true;
                    recur(path,res,nums,used);
                    used[i] = false;
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
