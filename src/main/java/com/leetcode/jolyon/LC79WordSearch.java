package com.leetcode.jolyon;

public class LC79WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (backtrack(board, word, 0, i, j, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int word_idx, int x, int y, boolean[][] visited) {
        if (word_idx == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1){
            return false;
        }
        if(visited[x][y]) return false;
        char c = word.charAt(word_idx);
        if(board[x][y]!=c) {
            return false;
        }else{
            visited[x][y] = true;
            boolean t=  backtrack(board, word, word_idx + 1, x + 1, y,visited) || backtrack(board, word, word_idx + 1, x, y + 1,visited)
                    || backtrack(board, word, word_idx + 1, x, y - 1,visited) || backtrack(board, word, word_idx + 1, x - 1, y,visited);
            if(!t){
                visited[x][y] = false;
            }
            return t;
        }
    }
}
