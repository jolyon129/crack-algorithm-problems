package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class TwitterReachingPoints {
    public boolean canReach(int x, int y, int e_x, int e_y) {

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] point = queue.pollFirst();
            int[][] dir = new int[][]{{point[1], 0}, {0, point[0]}};
            if (point[0] == e_x && point[1] == e_y) {
                return true;
            }
            for (int j = 0; j < 2; j++) {
                int[] newP = new int[]{point[0] + dir[j][0],
                        point[1] + dir[j][1]};
                if (newP[0] <= e_x && newP[1] <= e_y) {
                    queue.offerFirst(newP);
                }
            }
        }
        return false;
    }
}

