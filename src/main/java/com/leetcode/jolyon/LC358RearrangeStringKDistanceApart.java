package com.leetcode.jolyon;

import java.util.*;

public class LC358RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        int[] counts = new int[26];
        int L = s.length();
        for (int i = 0; i < L; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] w1, int[] w2) -> {
            if (w2[1] == w1[1]) {
                return w1[0] - w2[0];
            } else {
                return w2[1] - w1[1];
            }
        });
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) pq.add(new int[]{i, counts[i]});
            if (counts[i] > max) max = counts[i];
        }
        if ((max - 1) * (k - 1) + max > L) return "";
        Deque<int[]> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            int[] first = pq.poll();
            first[1]--;
            sb.append((char) (first[0] + 'a'));
            int slotNum = k - 1;
            if (first[1] > 0) stack.add(first);
            while (slotNum > 0) {
                if (pq.size() == 0){
                    if(stack.size()>0)  return "";
                    else{
                        return sb.toString();
                    }
                };
                int[] next = pq.poll();
                next[1]--;
                sb.append((char) (next[0] + 'a'));
                if (next[1] > 0) stack.add(next);
                slotNum--;
            }
            while (stack.size() > 0) {
                pq.add(stack.pop());
            }
        }
        return sb.toString();
    }
}
