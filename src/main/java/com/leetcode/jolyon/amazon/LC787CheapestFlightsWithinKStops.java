package com.leetcode.jolyon.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        {Start: (Des, Price)...}
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] f : flights) {
            if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
            prices.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        // Add the source into our queue
        pq.add(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0];
            int start = top[1];
            int end = top[2];
            if (start == dst) return price;
            // If we can transit more
            if (end > 0) {
                // (end->price)
                Map<Integer, Integer> neighbors = prices.getOrDefault(start, new HashMap<>());
                for (int a : neighbors.keySet()) {
                    pq.add(new int[]{price + neighbors.get(a), a, end - 1});
                }
            }
        }
        return -1;
    }
}
