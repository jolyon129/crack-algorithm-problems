package com.leetcode.jolyon.amazon;

import java.util.*;

public class MaximumFrequencyStack {
    // Using bucket
    class FreqStack1{
        // The length is the frequency of the numbers in that stack
        List<Stack<Integer>> bucket;
        HashMap<Integer, Integer> freqMap;

        public FreqStack1() {
            bucket = new ArrayList<>();
            freqMap = new HashMap<>();
        }

        public void push(int x) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
            int freq = freqMap.get(x);
            if (freq - 1 >= bucket.size()) {
                bucket.add(new Stack<Integer>());
            }
            bucket.get(freq - 1).add(x);
        }

        public int pop() {
            int freq = bucket.size();
            int x = bucket.get(freq - 1).pop();
            if (bucket.get(freq - 1).isEmpty()) bucket.remove(bucket.size() - 1);
            // If there is a tie for most frequent element,
            // the element closest to the top of the stack is removed and returned.
            freqMap.put(x, freqMap.get(x) - 1);
            if (freqMap.get(x) == 0) freqMap.remove(x);

            return x;
        }
    }
    // Using bucket
    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;
            group.putIfAbsent(f, new Stack<Integer>());
            group.get(f).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }
}
