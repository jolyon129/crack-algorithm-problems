package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC398RandomPickIndex {
    /**
     * Reservoir Sampling solution!
     * One Pass with no extra space!
     */
    static class Solution {
        int[] nums;
        Random rd;
        public Solution(int[] nums) {
            this.nums = nums;
            this.rd = new Random();
        }

        public int pick(int target) {

            int count = 0;
            int res = -1;
            for(int i=0;i<nums.length;i++){
                if(target == nums[i]){
                    count++;
                    if(rd.nextInt(count)==0) res=i;
                }
            }
            return res;
        }
    }

    static class BadSolution {
        Map<Integer, Integer> count = new HashMap<>();
        int[] nums;

        public BadSolution(int[] nums) {
            this.nums = nums;
            for (int n : nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }

        }

        public int pick(int target) {
            Random rd = new Random();
            int c = 1 + rd.nextInt(count.get(target));
            int targetIdx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    targetIdx++;
                    if (targetIdx == c) return i;
                }

            }
            throw new AssertionError();

        }
    }
}
