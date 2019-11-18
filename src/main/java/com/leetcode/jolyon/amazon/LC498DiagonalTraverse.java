package com.leetcode.jolyon.amazon;

public class LC498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }


        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int r = 0;
        int c = 0;
        for (int i = 0; i < rows * cols; i++) {
            res[i] = matrix[r][c];
            // even sum diagonal, go up right
            if ((r + c) % 2 == 0) {
                if (r - 1 >= 0 && c + 1 < cols) {
                    c = c + 1;
                    r = r - 1;
                } else if (r - 1 < 0 && c + 1 < cols) {
                    // if there is no row space, jump to a new diagonal
                    c = c + 1;
                } else if (r + 1 < rows && c + 1 > cols - 1) {
                    // if there is no column space, jump to a new diagonal
                    r = r + 1;
                }
            }
            // odd sum diagonal, go down left
            else if ((r + c) % 2 != 0) {
                if (r + 1 < rows && c - 1 >= 0) {
                    c = c - 1;
                    r = r + 1;
                } else if (r + 1 < rows && c - 1 < 0) {
                    // if there is no column space, jump to a new diagonal
                    r = r + 1;
                } else if (r + 1 > rows - 1 && c +1 < cols) {
                    // if there is no row space, jump to a new diagonal
                    c = c + 1;
                }
            }
        }
        return res;
    }
}
