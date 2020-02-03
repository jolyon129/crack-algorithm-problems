package com.leetcode.jolyon.amazon;

public class LC240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int M = matrix.length;
        if (M == 0) return false;
        int N = matrix[0].length;
        if (N == 0) {
            return false;
        }
        int row = M - 1;
        int col = 0;
        while (row >= 0 && col < N) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) {
                col++;
            }
        }
        return false;
    }
}
