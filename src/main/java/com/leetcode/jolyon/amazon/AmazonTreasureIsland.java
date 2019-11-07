package com.leetcode.jolyon.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/discuss/interview-question/347457/Amazon-or-OA-2019-or-Treasure-Island
 */
public class AmazonTreasureIsland {
    public int minPath(char[][] island) {
        Deque<int[]> deque = new ArrayDeque<>();
        int W = island[0].length;
        int H = island.length;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int step = -1;
        deque.add(new int[]{0, 0});
        while (deque.size() != 0) {
            step++;
            int level = deque.size();
            for (int i = 0; i < level; i++) {
                int[] point = deque.pollFirst();
                if (island[point[0]][point[1]] == 'X') return step;
                // Mark as visited
                island[point[0]][point[1]] = 'V';

                for (int[] d : directions) {
                    int[] newPoint = new int[]{point[0] + d[0], point[1] + d[1]};
                    if (isSafe(newPoint, H, W,island)) {
                        deque.add(newPoint);
                    }
                }
            }
        }
        return -1;
    }

    private boolean isSafe(int[] point, int H, int W, char[][] isLand) {
        if (point[0] < 0 || point[0] > H - 1 || point[1] < 0
                || point[1] > W - 1 || isLand[point[0]][point[1]] == 'D'||isLand[point[0]][point[1]]=='V') {
            return false;
        }
        return true;
    }
}
