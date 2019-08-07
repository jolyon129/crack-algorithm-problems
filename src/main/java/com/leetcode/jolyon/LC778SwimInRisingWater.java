package com.leetcode.jolyon;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class LC778SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>((w1, w2) -> {
            return grid[w1 / N][w1 % N] - grid[w2 / N][w2 % N];
        });
        Set<Integer> visited = new HashSet<>();
        heap.add(0);
        int ans = 0;
        int[] d_x = new int[]{-1, 1, 0, 0};
        int[] d_y = new int[]{0, 0, 1, -1};
        while (!heap.isEmpty()) {
            int k = heap.poll();
            int x = k / N, y = k % N;
            ans = Math.max(grid[x][y], ans);
            if (x == N - 1 && y == N - 1) return ans;
            for (int i = 0; i < 4; i++) {
                int new_x = x + d_x[i];
                int new_y = y + d_y[i];
                int new_k = new_x * N + new_y;
                if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N && !visited.contains(new_k)) {
                    heap.add(new_k);
                    visited.add(new_k);
                }
            }
        }
        throw new AssertionError();
    }

    // Solution 2
    static class solution2 {
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            int lo = grid[0][0], hi = N * N;
            while (lo <= hi) {
                int mi = lo + (hi - lo) / 2;
                if (!possible(mi, grid)) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
            return lo;
        }

        public boolean possible(int T, int[][] grid) {
            int N = grid.length;
            Set<Integer> seen = new HashSet();
            seen.add(0);
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};

            Stack<Integer> stack = new Stack();
            stack.add(0);

            while (!stack.empty()) {
                int k = stack.pop();
                int r = k / N, c = k % N;
                if (r == N - 1 && c == N - 1) return true;

                for (int i = 0; i < 4; ++i) {
                    int cr = r + dr[i], cc = c + dc[i];
                    int ck = cr * N + cc;
                    if (0 <= cr && cr < N && 0 <= cc && cc < N
                            && !seen.contains(ck) && grid[cr][cc] <= T) {
                        stack.add(ck);
                        seen.add(ck);
                    }
                }
            }

            return false;
        }
    }

}
