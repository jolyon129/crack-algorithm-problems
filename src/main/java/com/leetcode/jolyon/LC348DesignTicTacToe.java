package com.leetcode.jolyon;

public class LC348DesignTicTacToe {
    class TicTacToe {
        int[] rows;
        int[] columns;
        int mainDiagonal;
        int secDiagonal;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            rows = new int[n];
            columns = new int[n];
            mainDiagonal = 0;
            secDiagonal = 0;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either: 0: No one wins.
         * 1: Player 1 wins. 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int N = rows.length;
            rows[row] += player == 1 ? 1 : -1;
            columns[col] += player == 1 ? 1 : -1;
            if (row == col) {
                mainDiagonal += player == 1 ? 1 : -1;
            }
            if (rows.length - row - 1 == col) {
                secDiagonal += player == 1 ? 1 : -1;
            }
            if (Math.abs(rows[row]) == N || Math.abs(columns[col]) == N
                    || Math.abs(mainDiagonal) == N || Math.abs(secDiagonal) == N) {
                return player;
            }
            return 0;
        }

    }
}
