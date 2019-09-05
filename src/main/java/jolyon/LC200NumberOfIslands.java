package com.leetcode.jolyon;

public class LC200NumberOfIslands {
    static class DFSSolution {
        void dfs(char[][] grid, int r, int c) {
            int nr = grid.length;
            int nc = grid[0].length;

            if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            int num_islands = 0;
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        ++num_islands;
                        dfs(grid, r, c);
                    }
                }
            }

            return num_islands;
        }
    }

    static class UnionSolution{
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int num = grid.length * grid[0].length;
            int nr = grid.length;
            int nc = grid[0].length;
            UnionSet uf = new UnionSet(num);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        // if (r + 1 < nr && grid[r + 1][c] == '1') {
                        //     uf.union(r * nc + c, (r + 1) * nc + c);
                        // }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        // if (c + 1 < nc && grid[r][c + 1] == '1') {
                        //     uf.union(r * nc + c, r * nc + c + 1);
                        // }
                    }else{
                        uf.parents[r * nc + c]=-1;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < uf.parents.length; i++) {
                if (uf.parents[i] == i) {
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
                if (parents[idx] != idx) {
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
