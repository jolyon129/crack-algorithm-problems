package com.leetcode.jolyon;

public class LC684ReduntantConnection{
    int MAX_EDGE_VAL = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL + 1);
        for (int[] edge: edges) {
            if (dsu.find(edge[0])==dsu.find(edge[1])) return edge;
            dsu.union(edge[0],edge[1]);
        }
        throw new AssertionError();
    }

    class DSU {
        int[] disjoint_sets;
        int[] ranks;

        public DSU(int size) {
            disjoint_sets = new int[size];
            for (int i = 0; i < size; i++) disjoint_sets[i] = i;
            ranks = new int[size];
        }

        public int find(int x) {
            if (disjoint_sets[x] != x) disjoint_sets[x] = find(disjoint_sets[x]);
            return disjoint_sets[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) {
                return false;
            }
            if (ranks[xr] < ranks[yr]) {
                disjoint_sets[xr] = yr;
            } else{
                disjoint_sets[yr] = xr;
                if(ranks[x]== ranks[y]){
                    disjoint_sets[yr] = xr;
                    ranks[xr]++;
                }
            }
            return true;
        }
    }
}
