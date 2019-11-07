package com.leetcode.jolyon.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC451SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        List<Character>[] buckets = new List[s.length() + 1];
        for (char key : freqMap.keySet()) {
            int frequency = freqMap.get(key);
            if (buckets[frequency] == null)
                buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = buckets.length - 1; pos >= 0; pos--)
            if (buckets[pos] != null)
                for (char c : buckets[pos])
                    for (int i = 0; i < freqMap.get(c); i++)
                        sb.append(c);

        return sb.toString();
    }
}
