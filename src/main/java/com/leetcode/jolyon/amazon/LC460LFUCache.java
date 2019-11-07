package com.leetcode.jolyon.amazon;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LC460LFUCache {
    public class LFUCache {
        HashMap<Integer, Integer> keyToVal;
        HashMap<Integer, Integer> keyToFreq;
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeyList;
        int cap;
        int minFreq;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeyList = new HashMap<>();
            cap = capacity;
            minFreq = 0;
        }

        public int get(int key) {
            if(!keyToVal.containsKey(key))
                return -1;

            update(key);
            return keyToVal.get(key);
        }
        // update freq
        private void update (int key) {
            int freq = keyToFreq.get(key);
            keyToFreq.put(key, freq + 1);
            freqToKeyList.get(freq).remove(key);
            // Update the Min Frequency!
            if(freq == minFreq && freqToKeyList.get(freq).size() == 0)
                minFreq++;

            addToFreqToKeyList(freq + 1, key);
        }
        // Add (freq, key) to the freqToKeyList
        private void addToFreqToKeyList(int freq, int key) {
            freqToKeyList.putIfAbsent(freq, new LinkedHashSet<>());
            // always add to the tail of the linkedhashlist
            freqToKeyList.get(freq).add(key);
        }

        private void evict () {
            // the least recently used key would be evicted.
            // iterator will point to the head of the linkedhashlist (Queue)
            int key = freqToKeyList.get(minFreq).iterator().next();
            freqToKeyList.get(minFreq).remove(key);
            keyToVal.remove(key);
            keyToFreq.remove(key);
        }

        public void put(int key, int value) {
            if (cap <= 0)
                return;

            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                update(key);
                return;
            }

            if (keyToVal.size() >= cap)
                evict();

            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            addToFreqToKeyList(1, key);
            minFreq = 1;
        }
    }
}
