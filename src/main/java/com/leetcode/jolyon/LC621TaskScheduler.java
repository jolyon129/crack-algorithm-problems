package com.leetcode.jolyon;

import java.util.*;

public class LC621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            counts[tasks[i] - 'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] w1, int[] w2) -> {
            return w2[1] - w1[1];
        });
        for (int i = 0; i < 26; i++) {
            pq.add(new int[]{i, counts[i]});
        }

        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;
        while (pq.size() > 0) {
            int[] firstTask = pq.poll();
            res++;
            firstTask[1]--;
            if (firstTask[1] == 0) continue;
            int nIdle = n;
            stack.add(firstTask);
            while (nIdle > 0) {
                if (pq.size() > 0) {
                    int[] next = pq.poll();
                    next[1]--;
                    if (next[1] > 0) stack.add(next);
                }
                res++;
                nIdle--;
            }
            while (stack.size() > 0) {
                if (stack.peek()[1] > 0) {
                    pq.add(stack.pop());
                }
            }
        }
        return res;

    }
}
