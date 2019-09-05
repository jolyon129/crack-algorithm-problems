package com.leetcode.jolyon;

import java.util.*;

public class LC76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }
        List<Pair> s2 = new ArrayList<>();
        for(int i=0; i<s.length();i++){
            if(tMap.containsKey(s.charAt(i))){
                s2.add(new Pair(s.charAt(i),i));
            }
        }
        int left=0;
        int right=0;
        Integer[] ans = new Integer[2];
        int count = 0;
        while(right<s2.size()){
            char letter = s2.get(right).letter;
            window.put(letter, window.getOrDefault((letter), 0)+1);
            if(window.get(letter).equals( tMap.get(letter))){
                count++;
            }
            while (count == tMap.size() && left <= right) {
                Pair p1 = s2.get(left);
                Pair p2 = s2.get(right);
                if (ans[0] == null || p2.pos - p1.pos < ans[1] - ans[0]) {
                    ans[0] = p1.pos;
                    ans[1] = p2.pos;
                }
                char head = s2.get(left).letter;
                window.put(head, window.get(head) - 1);
                if(window.get(head)<tMap.get(head)) count--;
                left++;

            }
            right++;
        }
        if(ans[0]==null){
            return "";
        }
        return s.substring(ans[0], ans[1] + 1);
    }
    class Pair{
        public char letter;
        public int pos;
        public Pair(char letter, int pos){
            this.letter = letter;
            this.pos = pos;
        }
    }
}