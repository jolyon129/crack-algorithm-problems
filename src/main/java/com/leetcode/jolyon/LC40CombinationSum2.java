package com.leetcode.jolyon;

import java.util.*;

public class LC40CombinationSum2 {
    static class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            result = new ArrayList<>();
            Arrays.sort(candidates);
            Deque<Integer> candidate = new ArrayDeque<>();
            helper(candidates, candidate, target, 0);
            return result;
        }

        private void helper(int[] candidates, Deque<Integer> candidate, int target, int idx) {
            if (target < 0) return;
            if (target == 0) {
                this.result.add(new ArrayList<Integer>(candidate));
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                // Avoid duplication!!!! i>idx!!
                if (i > idx && candidates[i] == candidates[i - 1]) continue;
                else {
                    candidate.add(candidates[i]);
                    helper(candidates, candidate, target - candidates[i], i + 1);
                    // backtrack!! remove the last one!
                    candidate.pollLast();
                }

            }
            return;
        }
    }
}
