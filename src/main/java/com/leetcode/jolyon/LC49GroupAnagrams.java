package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String key = countingSort(strs[i]);
            map.putIfAbsent(key, new ArrayList<>());
            List<String> list = map.get(key);
            list.add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    public String countingSort(String list){
        int[] count = new int[26];
        for(int i=0;i<list.length();i++){
            count[list.charAt(i) - 'a']++;
        }
        for(int i=1;i<count.length;i++){
            count[i] = count[i - 1] + count[i];
        }
        char[] output = new char[list.length()];
        for(int i=0;i<list.length();i++){
            int idx = count[list.charAt(i)-'a']-1;
            output[idx] = list.charAt(i);
            count[list.charAt(i) - 'a']--;
        }
        return String.valueOf(output);
    }

}
