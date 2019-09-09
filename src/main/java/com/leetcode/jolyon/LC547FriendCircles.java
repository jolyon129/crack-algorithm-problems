package com.leetcode.jolyon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC547FriendCircles {
    static class DFSSolution {
        public int findCircleNum(int[][] M) {
            int res = 0;
            boolean[] visited = new boolean[M.length];
            for(int i=0;i<M.length;i++){
                if(visited[i]==false){
                    dfs(M,visited,i);
                    res+=1;
                }
            }
            return res;
        }
        private void dfs(int[][] M, boolean[] visited, int i){
            if(visited[i]) return;
            visited[i] = true;
            for(int t =0;t<M.length;t++){
                if(M[i][t]==1&&visited[t]==false){
                    dfs(M, visited,t);
                }
            }

        }
    }
    static class BFSSolution {
        public int findCircleNum(int[][] M) {
            boolean[] visited = new boolean[M.length];
            int res =0;
            for(int i=0;i<M.length;i++){
                if(visited[i]==false){
                    res++;
                    bfs(M, i, visited);
                }
            }
            return res;
        }
        public void bfs(int[][] M, int i, boolean[] visited){
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerFirst(i);
            while(!queue.isEmpty()){
                int idx = queue.pollLast();
                if(visited[idx]==true) continue;
                visited[idx] = true;
                for(int j=0;j<M.length;j++){
                    if(M[idx][j]==1&&visited[j]==false){
                        queue.offerFirst(j);
                    }
                }
            }
        }
    }
}
