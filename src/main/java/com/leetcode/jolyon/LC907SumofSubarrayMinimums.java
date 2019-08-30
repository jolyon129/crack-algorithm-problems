package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC907SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int[] PLE = new int[A.length];
        int[] NLE = new int[A.length];
        Deque<Integer> PLEDq = new ArrayDeque<>();
        Deque<Integer> NLEDq = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!PLEDq.isEmpty() && A[PLEDq.peekLast()] >= A[i]) {
                PLEDq.pollLast();
            }
            PLE[i] = PLEDq.isEmpty() ? -1 : PLEDq.peekLast();
            PLEDq.add(i);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            while (!NLEDq.isEmpty() && A[NLEDq.peekFirst()] > A[i]) {
                NLEDq.pollFirst();
            }
            NLE[i] = NLEDq.isEmpty() ? A.length : NLEDq.peekFirst();
            NLEDq.addFirst(i);
        }
        int sum = 0;

        int mod = 1000_000_007;
        for (int i = 0; i < A.length; i++) {
            int dis1 = i - PLE[i];
            int dis2 = NLE[i] - i;
            sum = (sum + A[i] * dis1 * dis2) % mod;
        }
        return sum;
    }
}
