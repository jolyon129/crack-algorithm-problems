package edu.nyu.jolyon;

import java.util.*;


public class LC692TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for(String s:words){
            hashMap.put(s, hashMap.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> hashMap.get(w1).equals(hashMap.get(w2)) ?
                        w1.compareTo(w2) : hashMap.get(w2) - hashMap.get(w1) );
        for(String s: hashMap.keySet()){
            heap.add(s);
        }

        List<String> res = new ArrayList<>();
        while (!heap.isEmpty() && k>0){
            res.add(heap.poll());
            k--;
        }
//        Collections.reverse(res);
        return res;
    }
}
