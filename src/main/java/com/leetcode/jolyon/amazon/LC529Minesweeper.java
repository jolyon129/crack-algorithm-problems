package com.leetcode.jolyon.amazon;

public class LC529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(click[0], click[1], visited, board);
        }
        return board;
    }

    void dfs(int r, int c, boolean[][] visited, char[][] board) {
        int N = board.length;
        int M = board[0].length;
        if (r < 0 || c < 0 || r >= N || c >= M || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (board[r][c] != 'E') return;
        int[] dr = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
        int[] dc = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 'M') {
                count++;
            }
        }

        if (count == 0) {
            board[r][c] = 'B';
            for (int i = 0; i < 8; i++) {
                dfs(r + dr[i], c + dc[i], visited, board);
            }
        } else {
            board[r][c] = (char) (count + '0');
        }
    }
}
