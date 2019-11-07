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
        int[] parents;
        int[] ranks;

        public DSU(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++) parents[i] = i;
            ranks = new int[size];
        }

        public int find(int x) {
            if (parents[x] != x) parents[x] = find(parents[x]);
            return parents[x];
        }

        public boolean union(int x, int y) {
            int xr = find(x), yr = find(y);
            if (xr == yr) {
                return false;
            }
            if (ranks[xr] < ranks[yr]) {
                parents[xr] = yr;
            } else{
                parents[yr] = xr;
                if(ranks[x]== ranks[y]){
                    ranks[xr]++;
                }
            }
            return true;
        }
    }
}
