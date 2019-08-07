package com.leetcode.jolyon;

import java.util.*;

public class LC767ReorganizeString {
    static class Solution1 {
        public String reorganizeString(String S) {
            int L = S.length();
            Map<Character, Integer> map = new HashMap<>();
            for (char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
            PriorityQueue<int[]> pq = new PriorityQueue<>((int[] w1, int[] w2) -> {
                return w2[1] - w1[1];
            });
            for (char c : map.keySet()) {
                if (map.get(c) > (L + 1) / 2) return "";
                pq.add(new int[]{(int) c, map.get(c)});
            }
            StringBuilder sb = new StringBuilder();
            while (pq.size() >= 2) {
                int[] first = pq.poll();
                first[1]--;
                sb.append((char) first[0]);
                int[] sec = pq.poll();
                sec[1]--;
                sb.append((char) sec[0]);
                if (first[1] > 0) pq.offer(first);
                if (sec[1] > 0) pq.offer(sec);
            }
            if (pq.size() > 0) {
                int[] tmp = pq.poll();
                if (tmp[1] > 1) return "";
                sb.append((char) tmp[0]);
            }
            return sb.toString();
        }
    }
}
