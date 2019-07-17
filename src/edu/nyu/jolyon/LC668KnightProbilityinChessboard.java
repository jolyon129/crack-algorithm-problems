package edu.nyu.jolyon;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class LC668KnightProbilityinChessboard {
    /**
     * Using two-dimensional DP
     * @param N
     * @param K
     * @param sr
     * @param sc
     * @return
     */
    public double knightProbability(int N, int K, int sr, int sc) {
        // Default value is zero;
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
        // use dp to represent the previous step of dp/
        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            // Use dp2 to represent the current step of dp
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = r + dr[k];
                        int cc = c + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row : dp) {
            for (double x : row) ans += x;
        }
        return ans;
    }

    /**
     * This method is naive BFS and its wrong!!
     * We are repeatedly visiting the same location and adding them to our queue,
     * which makes the queue really huge!
     *
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability1(int N, int K, int r, int c) {
        int[][] directions = {{2, 1}, {2, -1}, {-2, -1}, {-2, 1},
                {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
        if (K == 0) {
            if (check(new int[]{r, c}, N)) {
                return 1;
            } else {
                return 0;
            }
        }
        int[][] visited = new int[N - 1][N - 1];
        ArrayDeque<int[]> queue = new ArrayDeque<>(N);
        double total = Math.pow(8, K);
        int x = r;
        int y = c;
        for (int[] d : directions) {
            int[] new_pos = new int[2];
            new_pos[0] = x + d[0];
            new_pos[1] = y + d[1];
            if (check(new_pos, N)) queue.add(new_pos);
        }
        K--;
        int[] tmp;
        while (K > 0) {
            int len = queue.size();
            while (len > 0) {
                tmp = queue.poll();
                for (int[] d : directions) {
                    int[] pos = new int[2];
                    pos[0] = tmp[0] + d[0];
                    pos[1] = tmp[1] + d[1];
                    if (check(pos, N)) queue.add(pos);
                }
                len--;
            }
            K--;
        }

        return queue.size() / total;
    }

    private boolean check(int[] pos, int N) {
        if (pos[0] >= 0 && pos[1] >= 0 && pos[0] <= N - 1 && pos[1] <= N - 1) {
            return true;
        } else {
            return false;
        }
    }
}
