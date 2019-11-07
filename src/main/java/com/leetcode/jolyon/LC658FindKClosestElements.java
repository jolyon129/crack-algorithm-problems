package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Mid index represent the leftmost index of our last window.
        // We keep looping until we find the optimal leftmost idx for our
        // window.
        // When terminate, lo = mid.
        // The hi should start with arr.length-k
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            // Could we do better if we move right?
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i + lo > arr.length) {
                break;
            }
            res.add(arr[i + lo]);
        }
        return res;
    }
}
