package com.leetcode.jolyon;

public class LC517SuperWashingMachines {
    public class Solution {
        public int findMinMoves(int[] machines) {
            int n = machines.length;
            int sum = 0;
            for (int num : machines) {
                sum += num;
            }
            if (sum % n != 0) {
                return -1;
            }
            int avg = sum / n;
            int[] leftSums = new int[n];
            int[] rightSums = new int[n];
            for (int i = 1; i < n; i ++) {
                leftSums[i] = leftSums[i-1] + machines[i-1];
            }
            for (int i = n - 2; i >= 0; i --) {
                rightSums[i] = rightSums[i+1] + machines[i+1];
            }
            int move = 0;
            for (int i = 0; i < n; i ++) {
                int expLeft = i * avg;
                int expRight = (n - i - 1) * avg;
                int left = 0;
                int right = 0;
                if (expLeft > leftSums[i]) {
                    left = expLeft - leftSums[i];
                }
                if (expRight > rightSums[i]) {
                    right = expRight - rightSums[i];
                }
                move = Math.max(move, left + right);
            }
            return move;
        }
    }
}
