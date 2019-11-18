package com.leetcode.jolyon.amazon;

import java.util.*;

public class LC675CutOffTreesForGolfEvent {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int N = forest.size();
        int M = forest.get(0).size();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        trees.sort((w1, w2) -> {
            return forest.get(w1[0]).get(w1[1]) - forest.get(w2[0]).get(w2[1]);
        });

        int[] cur = new int[]{0, 0};
        int ans = 0;
        for (int[] tree : trees) {
            int d= distance(cur, tree, forest);
            if(d==-1) return -1;
            ans += d;
            cur = tree;
        }
        return ans;
    }

    int distance(int[] cur, int[] target, List<List<Integer>> forest) {
        int N = forest.size();
        int M = forest.get(0).size();
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        int[][] visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur[0]][cur[1]] = 1;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] tree = queue.poll();
                if (tree[0] == target[0] && tree[1] == target[1]) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    int[] next = new int[]{tree[0] + dr[i], tree[1] + dc[i]};
                    if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < M
                            && visited[next[0]][next[1]] == 0 && forest.get(next[0]).get(next[1]) > 0) {
                        // Add the node into visited at this place!!!
                        visited[next[0]][next[1]] = 1;
                        queue.add(next);
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }
}
