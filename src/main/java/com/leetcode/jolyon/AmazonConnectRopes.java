package com.leetcode.jolyon;

import java.util.PriorityQueue;

/**
 *
 * Given n ropes of different lengths, we need to connect these ropes into one
 * rope. We can connect only 2 ropes at a time. The cost required to connect 2
 * ropes is equal to sum of their lengths. The length of this connected rope is
 * also equal to the sum of their lengths. This process is repeated until n
 * ropes are connected into a single rope. Find the min possible cost required
 * to connect all ropes.
 */

/* https://leetcode.com/discuss/interview-question/344677/Amazon-or-Online-Assessment-2019-or-Min-Cost-to-Connect-Ropes
 * Input: ropes = [8, 4, 6, 12]
 * Output: 58
 * Explanation: The optimal way to connect ropes is as follows
 * 1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
 * 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
 * 3. Connect the ropes of length 18 and 12 (cost is 30).
 * Total cost to connect the ropes is 10 + 18 + 30 = 58
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
