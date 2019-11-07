package com.leetcode.jolyon.quora;

import java.util.HashMap;
import java.util.Map;

public class MatrixQueries {
    int solve(int[] array, int[][] matrix) {
        int N = array.length;
        Map<Integer, Integer>[] freqMap = new Map[array.length + 1];
        freqMap[0] = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            freqMap[i] = new HashMap<>();
            Map<Integer, Integer> prev = freqMap[i - 1];
            for (int key : prev.keySet()) {
                freqMap[i].put(key, prev.get(key));
            }
            freqMap[i].put(array[i - 1],
                    freqMap[i].getOrDefault(array[i - 1], 0) + 1);
        }

        int res = 0;
        for (int[] query : matrix) {
            int target = query[2];
            int l = query[0];
            int r = query[1];
            res += freqMap[r + 1].getOrDefault(target,0) - freqMap[l].getOrDefault(target,0);
        }
        return res;
    }
}
