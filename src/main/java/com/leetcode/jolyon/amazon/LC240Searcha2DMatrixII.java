package com.leetcode.jolyon.amazon;

public class LC240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null) return false;
        int N = matrix.length;
        int M = matrix[0].length;
        if (N == 0 || M == 0) {
            return false;
        }
        int y = 0;
        int x = M - 1;
        while (x >= 0 && y < N) {
            if (target == matrix[y][x]) {
                return true;
            } else if (target < matrix[y][x]) {
                x--;
            } else if (target > matrix[y][x]) {
                y++;
            }
        }
        return false;
    }
}
