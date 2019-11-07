package com.leetcode.jolyon.quora;

import java.util.HashMap;
import java.util.Map;

public class DivideArray {
    void divideArray(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] a = new int[N / 2];
        int[] b = new int[N / 2];
        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        int aCounter=0;
//
    }
}
