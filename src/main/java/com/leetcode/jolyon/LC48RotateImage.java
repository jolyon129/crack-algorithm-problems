package com.leetcode.jolyon;

public class LC48RotateImage {
    public void rotate(int[][] matrix) {
        int lo = 0;
        int N = matrix.length;
        int hi = matrix.length - 1;
        while (lo < hi) {
            // exclusive
            int length = hi - lo;
            for (int i = 0; i < length; i++) {
                swap(matrix, lo, lo + i, lo + i, hi);
                swap(matrix, lo, lo + i, hi, hi - i);
                swap(matrix, lo, lo + i, hi - i, lo);
            }
            lo++;
            hi--;
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

}
