package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dc = {1, 0, -1, 0};
        int[] dr = {0, 1, 0, -1};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int nextRow = r + dr[di];
            int nextColumn = c + dc[di];
            if (nextRow < 0 || nextRow >= R || nextColumn < 0 || nextColumn >= C || seen[nextRow][nextColumn]) {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }else{
                r = nextRow;
                c = nextColumn;
            }
        }
        return ans;
    }
}
