package com.leetcode.jolyon.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, List<Integer>> buckets = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int maxFreq = -1;

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        for (int num : freqMap.keySet()) {
            int frequency = freqMap.get(num);
            buckets.putIfAbsent(frequency, new ArrayList<>());
            buckets.get(frequency).add(num);
            maxFreq = Math.max(frequency, maxFreq);
        }

        List<Integer> res = new ArrayList<>();
        for (int t = maxFreq; t > 0; t--) {
            if(!buckets.containsKey(t)) continue;
            for (int num : buckets.get(t)) {
                res.add(num);
                if (res.size() == k) return res;
            }
        }
        return res;
    }}
