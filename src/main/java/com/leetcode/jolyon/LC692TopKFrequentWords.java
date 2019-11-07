package com.leetcode.jolyon;

import java.util.*;


public class LC692TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w1.compareTo(w2) : count.get(w2) - count.get(w1) );

        for (String word: count.keySet()) {
            heap.offer(word);

        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()&&k>0){
            ans.add(heap.poll());
            k--;
        }
        return ans;
    }
}
