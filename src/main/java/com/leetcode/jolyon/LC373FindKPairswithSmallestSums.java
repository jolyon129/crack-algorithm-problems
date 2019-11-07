package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC373FindKPairswithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] w1, int[] w2) ->
                Integer.compare(w1[0] + w1[1], w2[0] + w2[1]));
        List<List<Integer>> res = new ArrayList<>();
        if (nums2.length == 0 || nums1.length == 0) {
            return res;
        }
        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && pq.size() > 0) {
            int[] pair = pq.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(pair[0]);
            tmp.add(pair[1]);
            res.add(tmp);
            int nextIdx = pair[2] + 1;
            if (nextIdx < nums2.length) {
                pq.offer(new int[]{pair[0], nums2[nextIdx], nextIdx});
            }
            k--;
        }
        return res;
    }
}
