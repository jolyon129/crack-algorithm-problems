package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            int target = 0 - nums[i];
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                if (nums[head] + nums[tail] == target) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[head], nums[tail])));
                    while (head < tail && nums[head] == nums[head+1]) head++;
                    while (head < tail && nums[tail] == nums[tail-1]) tail--;
                    head++;
                    tail--;
                } else if (nums[head] + nums[tail] > target) {
                    tail--;
                } else {
                    head++;
                }
            }

        }
        return res;
    }
}
