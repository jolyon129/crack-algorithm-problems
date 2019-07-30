package edu.nyu.jolyon;

import java.util.*;

public class LC819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        String[] p = paragraph.split("\\W+");
        String ans = "";
        int maxFreq = 0;
        for (String word : p) {
            word = word.toLowerCase();
            if (!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > maxFreq) {
                    maxFreq = map.get(word);
                    ans = word;
                }
            }
        }
        return ans;
    }
}
