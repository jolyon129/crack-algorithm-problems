package com.leetcode.jolyon;

public class DSU {
    int[] parents;
    int[] ranks;

    DSU(int num) {
        parents = new int[num + 1];
        ranks = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            parents[i] = i;
        }
    }

    int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    boolean union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if (p1 == p2) return false;
        else {
            if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1;
            } else if (ranks[p1] < ranks[p2]) {
                parents[p1] = parents[p2];
            } else {
                if (x < y) {
                    parents[p2] = p1;
                    ranks[p1] += 1;
                } else {
                    parents[p1] = p2;
                    ranks[p2] += 1;
                }
            }
        }
        return true;
    }


}
