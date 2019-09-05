package com.leetcode.jolyon;

import java.util.*;

public class LC37SudokuSolver {
    static class Solution {
        char[][] board;
        Set<Integer>[] row;
        Set<Integer>[] column;
        Set<Integer>[] box;
        public void solveSudoku(char[][] board) {
            this.board = board;
            Set<Integer>[] row = new Set[9];
            Set<Integer>[] column = new Set[9];
            Set<Integer>[] box = new Set[9];
            this.row = row;
            this.column = column;
            this.box = box;
            for (int i = 0; i < 9; i++) {
                row[i] = new HashSet();
                column[i] = new HashSet();
                box[i] = new HashSet();
                for (int j = 1; j < 10; j++) {
                    row[i].add(j);
                    column[i].add(j);
                    box[i].add(j);
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') continue;
                    int nBox = i / 3 * 3 + j / 3;
                    row[i].remove(board[i][j] - '0');
                    column[j].remove(board[i][j] - '0');
                    box[nBox].remove(board[i][j] - '0');
                }
            }
            backtrack(0, 0);
        }

        private boolean backtrack(int i, int j) {
            if (i == 8 && j == 9) return true;
            if (j == 9) {
                i = i + 1;
                j = 0;
            }
            if (board[i][j] != '.') {
                return backtrack(i, j + 1);
            } else {
                List<Integer> candidates = getCandidates(i, j);
                if (candidates.size() == 0) return false;
                for (int c : candidates) {
                    board[i][j] = (char) (c + '0');
                    row[i].remove(c);
                    column[j].remove(c);
                    box[i / 3 * 3 + j / 3].remove(c);
                    if (!backtrack(i, j + 1)) {
                        row[i].add(c);
                        column[j].add(c);
                        box[i / 3 * 3 + j / 3].add(c);
                        board[i][j] = '.';
                    }else{
                        // Be Careful!!!
                        return true;
                    }
                }
                return false;
            }

        }

        private List<Integer> getCandidates(int i, int j) {
            int nB = i / 3 * 3 + j / 3;
            Set<Integer> temp;
            if ((row[i].size() > column[j].size()) && (column[j].size() > box[nB].size())) {
                temp = row[i];
            } else if (column[j].size() > row[i].size() && row[i].size() > box[nB].size()) {
                temp = column[j];
            } else {
                temp = box[nB];
            }
            List<Integer> res = new ArrayList<>();
            for (int k : temp) {
                if (column[j].contains(k) && box[nB].contains(k) && row[i].contains(k)) {
                    res.add(k);
                }
            }
            return res;

        }
    }
}
