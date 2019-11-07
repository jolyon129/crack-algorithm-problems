package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<List<Integer>> generateMatrix(int n) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dc = {1, 0, -1, 0};
        int[] dr = {0, 1, 0, -1};
        int r = 0, c = 0, directionIdx = 0;
        for (int i = 0; i < n * n; i++) {
            matrix[r][c] = i+1;
            visited[r][c] = true;
            int nextRow = r + dr[directionIdx];
            int nextColumn = c + dc[directionIdx];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || visited[nextRow][nextColumn]) {
                directionIdx = (directionIdx + 1) % 4;
                r += dr[directionIdx];
                c += dc[directionIdx];
            }else{
                r = nextRow;
                c = nextColumn;
            }
        }
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(matrix[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
