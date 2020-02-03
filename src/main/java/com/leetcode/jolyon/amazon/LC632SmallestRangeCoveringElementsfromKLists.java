package com.leetcode.jolyon.amazon;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC632SmallestRangeCoveringElementsfromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o[0]).get(o[1])));
        int maxNum = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{i, 0});
            maxNum = Math.max(maxNum, nums.get(i).get(0));
        }
        while (q.size() == nums.size()) {
            // Extract the root of the heap
            int idx[] = q.poll(), row = idx[0], col = idx[1];
            if (end - start > maxNum - nums.get(row).get(col)) {
                start = nums.get(row).get(col);
                end = maxNum;
            }
            if (col + 1 < nums.get(row).size()) {
                q.offer(new int[]{row, col + 1});
                // Update the maximal number among the min heap
                maxNum = Math.max(maxNum, nums.get(row).get(col + 1));
            }
        }
        return new int[]{start, end};
    }
}
