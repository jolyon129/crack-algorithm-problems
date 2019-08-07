package com.leetcode.jolyon;

import java.util.PriorityQueue;
/*
 https://leetcode.com/discuss/interview-question/344677/Amazon-or-Online-Assessment-2019-or-Min-Cost-to-Connect-Ropes
 */
public class AmazonConnectRopes {
    public int connectRopes(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int rope : ropes) {
            pq.add(rope);
        }
        while (pq.size() > 0) {
            int r1 = pq.poll();
            int r2 = pq.poll();
            int tmp = r1 + r2;
            res += tmp;
            pq.offer(tmp);
        }
        return res;
    }
}
