package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1192CriticalConnectionsinaNetwork {
    class Solution {
        int time = 0; // time when discover each vertex

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            int[] disc = new int[n], low = new int[n];
            // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
            List<Integer>[] graph = new ArrayList[n];
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();

            }
            // build graph
            for (int i = 0; i < connections.size(); i++) {
                int from = connections.get(i).get(0), to = connections.get(i).get(1);
                graph[from].add(to);
                graph[to].add(from);
            }
            // A serious pitfall!!
            // We must call backtrack on each node! Otherwise we will miss the
            // special case of the staring node!
            for (int i = 0; i < n; i++) {
                if (disc[i] == 0) {
                    dfs(i, low, disc, graph, res, 0);
                }
            }
            return res;
        }

        /**
         * After each recursion, we assign the discover time to the current
         * node and we finish filling the low[v] where v is one of current
         * node's neighbors.
         *
         * @param u
         * @param low
         * @param disc
         * @param graph
         * @param res
         * @param pre previous node.
         */
        private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
            disc[u] = low[u] = ++time; // discover u
            for (int j = 0; j < graph[u].size(); j++) {
                int nei = graph[u].get(j);
                if (nei == pre) {
                    continue; // if parent vertex, ignore
                }
                if (disc[nei] == 0) { // if not discovered
                    dfs(nei, low, disc, graph, res, u);
                }
                low[u] = Math.min(low[u], low[nei]);
                if (low[nei] > disc[u]) {
                    // u - nei is critical, there is no path for nei to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, nei));
                }
            }
        }

    }
}
