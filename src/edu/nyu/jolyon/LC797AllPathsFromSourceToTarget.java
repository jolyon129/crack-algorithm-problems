package edu.nyu.jolyon;

import java.util.*;

public class LC797AllPathsFromSourceToTarget {
    static class sol1 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<Deque<Integer>> tmp = recur(graph, 0);
            List<List<Integer>> res = new ArrayList<>();
            for(Deque<Integer> dq:tmp){
                res.add(new ArrayList<>(dq));
            }
            return res;
        }

        private List<Deque<Integer>> recur(int[][] graph, int node) {
            List<Deque<Integer>> res = new ArrayList<>();
            if (node == graph.length - 1) {
                Deque<Integer> path = new ArrayDeque<>();
                path.add(node);
                res.add(path);
                return res;
            }
            for (int nei : graph[node]) {
                for (Deque<Integer> path : recur(graph, nei)) {
                    path.addFirst(node);
                    res.add(path);
                }
            }
            return res;
        }
    }

    static class sol2 {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            path.add(0);
            dfsSearch(graph, 0, res, path);

            return res;
        }

        private void dfsSearch(int[][] graph, int node, List<List<Integer>> res,
                               List<Integer> path) {
            if (node == graph.length - 1) {
                res.add(new ArrayList<Integer>(path));
                return;
            }

            for (int nextNode : graph[node]) {
                path.add(nextNode);
                dfsSearch(graph, nextNode, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
