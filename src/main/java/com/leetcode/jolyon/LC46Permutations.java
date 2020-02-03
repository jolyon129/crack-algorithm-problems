package com.leetcode.jolyon;


import java.util.*;

public class LC46Permutations {
    static class NotGoodSolution {
        public List<List<Integer>> permute(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            recur(set, path, res);
            return res;
        }

        private void recur(Set<Integer> set, List<Integer> path, List<List<Integer>> res) {
            if (set.size() == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            int size = set.size();
            int len = path.size();
            Iterator iter = set.iterator();
            for (int j = 0; j < size; j++) {
                Integer i = (Integer) iter.next();
                path.add(i);
                // The creation is timestamp-consuming
                Set<Integer> newSet = new HashSet(set);
                newSet.remove(i);
                recur(newSet, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    static class BetterSolution{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            // Arrays.sort(nums); // not necessary
            backtrack(list, new ArrayList<>(), nums);
            return list;
        }

        private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
            if(tempList.size() == nums.length){
                list.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){
                    if(tempList.contains(nums[i])) continue; // element already exists, skip
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
