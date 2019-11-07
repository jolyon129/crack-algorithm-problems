package com.leetcode.jolyon.amazon;

import java.util.*;

public class LC207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[N];
        int[] inDegree = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        // edge: e[0]<--e[1]
        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            inDegree[e[0]]++;
        }
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                // In topological sorting, we first visit the node with 0
                // degree.
                queue.add(i);
            }
        }
        // Record how many node we will visit if we start
        // by those nodes with 0 in-degree .
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int j : graph[node]) {
                inDegree[j]--;
                // Add nodes with 0 in-degree into our queue
                if (inDegree[j] == 0) {
                    queue.add(j);
                }
            }
        }
        // If we can visit all courses then return true
        return count == N;
    }

    // Detect cycle
    public boolean canFinishUsingCycle(int numCourses, int[][] prerequisites) {
        int N = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[N];
        int[] inDegree = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        // edge: e[0]<--e[1]
        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
//            inDegree[e[0]]++;
        }
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                if(hasCycle(graph,i,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] graph, int node,
                             int[] visited) {
        visited[node]=1;
        for(int nei: graph[node]){
            if(visited[nei]==1){
                return true;
            }
            if(visited[nei]==0){
                if(hasCycle(graph, nei, visited)) return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}
