package com.leetcode.jolyon;

public class LC723CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int N = board.length, M = board[0].length;
        boolean toDrop = true;
        while (toDrop) {
            toDrop = false;
            // At each cell, check its rightward and downward direction.
            // First step is to flag the potential cells, assign the negative
            // value to them.
            // When check weather it is a "line", we use absolute value!
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // take absolute value!
                    int val = Math.abs(board[i][j]);
                    // if already dropped
                    if (val == 0) continue;
                    // Check rightward direction, check the 2 cells on its right
                    // if there is a "line"
                    if (j < M - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        toDrop = true;
                        // assign negative value
                        for (int tmp = 0; tmp < 3; tmp++) {
                            board[i][j + tmp] = -val;
                        }

                    }
                    // check downward direction
                    if (i < N - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        toDrop = true;
                        for (int tmp = 0; tmp < 3; tmp++) {
                            board[i+tmp][j] = -val;
                        }
                    }
                }
            }
            if (toDrop) { // if we need to drop
                for (int j = 0; j < M; j++) {
                    int slow = N - 1;
                    // i is the fast pointer, and slow is the slow pointer.
                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[slow--][j] = board[i][j];
                        }
                    }
                    // Assign 0 to new cells
                    for (int k = slow; k >= 0; k--) board[k][j] = 0;
                }
            }
        }
        return board;
    }
}
