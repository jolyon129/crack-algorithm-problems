package com.leetcode.jolyon.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int t = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[t] = node;
            t++;
            for (int nei : graph[node]) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        if (t != numCourses) return new int[0];
        else return res;
    }
}
