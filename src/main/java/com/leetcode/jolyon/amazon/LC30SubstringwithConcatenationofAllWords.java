package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words){
        Map<String, Integer> map = new HashMap<>();
        if(s.length()==0||words.length==0) return new ArrayList<Integer>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        int wordLength = words[0].length();
        int N = s.length();
        List<Integer> res = new ArrayList<>();
        for (int idx = 0; idx < N - wordLength * words.length + 1; idx++) {
            int j = idx;
            Map<String, Integer> copy = new HashMap<>(map);
            int K = words.length;
            while (K > 0 && j < N - wordLength+1) {
                String word = s.substring(j, j + wordLength);
                if (copy.containsKey(word)) {
                    copy.put(word, copy.get(word) - 1);
                    if (copy.get(word) == 0) copy.remove(word);
                    K--;
                } else {
                    break;
                }
                j = j + wordLength;
            }
            if (K == 0) res.add(idx);
        }
        return res;
    }
}
