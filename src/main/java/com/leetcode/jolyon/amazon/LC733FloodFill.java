package com.leetcode.jolyon.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class LC733FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int[] dr = new int[]{0, 0, 1, -1};
            int[] dc = new int[]{1, -1, 0, 0};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sr, sc});
            int color = image[sr][sc];
            int N = image.length;
            int M = image[0].length;
            boolean[][] visited = new boolean[N][M];
            visited[sr][sc] = true;
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                image[p[0]][p[1]] = newColor;
                for (int i = 0; i < 4; i++) {
                    int nr = p[0] + dr[i];
                    int nc = p[1] + dc[i];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < M
                            && !visited[nr][nc] && image[nr][nc] == color) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            return image;
        }
    }
}
