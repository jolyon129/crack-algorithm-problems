package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnections {
    int time = 0;

    public class PairInt {
        int first;
        int second;

        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    List<PairInt> criticalEdges = new ArrayList<>();

    List<PairInt> solve(List<PairInt> edges, int n) {
        List<Integer>[] adj = new ArrayList[n + 1];
        int[] earliestTime = new int[n + 1];
        int[] discover = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (PairInt edge : edges) {
            int start = edge.first;
            int end = edge.second;
            adj[start].add(end);
            adj[end].add(start);
        }
        // A serious pitfall!!
        // We must call backtrack on each node! Otherwise we will miss the
        // special case of the staring node!
        for (int i = 1; i < n + 1; i++) {
            if (discover[i] == 0) {
                dfs(i, earliestTime, discover, adj, 0);
            }
        }
        return criticalEdges;
    }

    private void dfs(int node, int[] earliestTime, int[] discover,
                     List<Integer>[] adj, int pre) {
        discover[node] = ++time;
        earliestTime[node] = discover[node];
        List<Integer> neighbors = adj[node];
        for (int nei : neighbors) {
            if (nei == pre) {
                continue; // if this is the parent vertex, ignore, since it's
                // the same edge!.
            }
            if (discover[nei] == 0) {
                dfs(nei, earliestTime, discover, adj, nei);
            }
            earliestTime[node] = Math.min(earliestTime[node], earliestTime[nei]);
            if (earliestTime[nei] > discover[node]) {
                PairInt pair;
                // rearrange the order
                if (nei < node) {
                    pair = new PairInt(nei, node);
                } else {
                    pair = new PairInt(node, nei);
                }
                criticalEdges.add(pair);
            }
        }

    }

}
