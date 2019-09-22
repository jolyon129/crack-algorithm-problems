package com.leetcode.jolyon;

public class LC977SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        int mid = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0 && mid == -1) {
                mid = i;
            }
            A[i] = A[i] * A[i];
        }
        if (mid == 0) return A;
        else {
            return merge(A, 0, A.length, mid);
        }

    }

    // Exclude j
    int[] merge(int[] A, int lo, int hi, int mid) {
        int[] cache = new int[hi - lo];
        int m = mid - 1;
        int n = mid;
        int idx = 0;
        while (m >= 0) {
            while (n < hi && A[m] > A[n]) {
                cache[idx] = A[n];
                n++;
                idx++;
            }
            cache[idx] = A[m];
            idx++;
            m--;
        }
        for (int t = 0; t < idx; t++) {
            A[lo + t] = cache[t];
        }
        return A;
    }
}
