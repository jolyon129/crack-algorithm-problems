package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC317ShortestDistancefromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numBuildings = 0;
        int[][] sumDistance = new int[m][n];

        int[][] reach = new int[m][n];
        Integer ans = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j, reach, sumDistance, numBuildings)) {
                        return -1;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numBuildings) {
                    if (ans == null || ans > sumDistance[i][j]) {
                        ans = sumDistance[i][j];
                    }

                }
            }
        }
        if (ans == null) {
            return -1;
        } else {
            return ans;
        }
    }

    // We start BFS on each building.
    // If we find out that buildings are not connected, return false to early prune
    private boolean bfs(int[][] grid, int x, int y, int[][] reach, int[][] sumDistance, int numBuildings) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        // We need to resest `visited` whenever we start a new BFS
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int countBuilding = 1;
        int dist = 0;
        while (queue.size() != 0) {
            dist++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] pos = queue.pollFirst();
                int r = pos[0];
                int c = pos[1];
                visited[r][c] = true;
                //Keep track of how many buildings are connected to the
                // current building
                int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int j = 0; j < 4; j++) {
                    int newR = pos[0] + direction[j][0];
                    int newC = pos[1] + direction[j][1];
                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length
                            && !visited[newR][newC]) {
                        /**
                         * IMPORTANT!!! We must isAWord it as visited
                         * immediately!!!!!!!
                         */
                        visited[newR][newC] = true;
                        if(grid[newR][newC] == 0){
                            sumDistance[newR][newC] += dist;
                            reach[newR][newC]++;
                            queue.add(new int[]{newR, newC});
                        }
                        else if (grid[newR][newC] == 1) {
                            countBuilding++;
                        }
                    }
                }


            }
        }
        // Earlier return
        if (countBuilding != numBuildings) {
            return false;
        } else {
            return true;
        }
    }
}
