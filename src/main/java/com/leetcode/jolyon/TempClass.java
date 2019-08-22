package com.leetcode.jolyon;

public class TempClass {
    class Solution {
        public int numIslands(char[][] grid) {
            int num = grid.length * grid[0].length;
            UnionSet unionSet = new UnionSet(num);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        unionSet.parents[calculate(i, j, grid)] = -1;
                    } else {
                        if (i != 0) {
                            if (grid[i][j] == grid[i - 1][j])
                                unionSet.union(calculate(i, j, grid), calculate(i - 1, j, grid));
                        }
                        if (j != 0) {
                            if (grid[i][j] == grid[i][j - 1])
                                unionSet.union(calculate(i, j, grid), calculate(i, j - 1, grid));
                        }
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < unionSet.parents.length; i++) {
                if (unionSet.parents[i] == i) {
                    count++;
                }
            }
            return count;
        }

        public int calculate(int r, int c, char[][] grid) {
            return r * grid.length + c;
        }

        public class UnionSet {
            int[] ranks;
            int[] parents;

            public UnionSet(int num) {
                ranks = new int[num];
                parents = new int[num];
                for (int i = 0; i < num; i++) {
                    parents[i] = i;
                }
            }

            public int find(int idx) {
                while (parents[idx] != idx) {
                    parents[idx] = find(parents[idx]);
                }
                return parents[idx];
            }

            public void union(int i1, int i2) {
                if (find(i1) == find(i2)) return;
                if (ranks[i1] < ranks[i2]) {
                    parents[find(i1)] = find(i2);
                } else if (ranks[i1] > ranks[i2]) {
                    parents[find(i2)] = find(i1);
                } else {
                    parents[find(i1)] = find(i2);
                    ranks[find(i2)] += 1;
                }
            }
        }
    }
}
