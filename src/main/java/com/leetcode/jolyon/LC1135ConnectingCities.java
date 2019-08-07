package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC1135ConnectingCities {
    /**
     * Use sort
     */
    static class Solution1 {
        public int minimumCost(int N, int[][] connections) {
            if(connections.length<N-1) return -1;
            int cost = 0;
            List<List<Integer>> edges = new ArrayList<>();
            for(int i=0;i<connections.length;i++){
                List<Integer> edge = new ArrayList<>();
                for(int c: connections[i]){
                    edge.add(c);
                }
                edges.add(edge);
            }
            edges.sort((w1,w2)->w1.get(2)-w2.get(2));
            Union union = new Union(N);
            for(List<Integer> edge:edges){
                if(union.find(edge.get(0))==union.find(edge.get(1))){
                    continue;
                }
                union.unionSet(edge.get(0),edge.get(1));
                cost += edge.get(2);
                if(union.count==1){
                    break;
                }
            }
            int c = union.count();
            // return cost;
            if(union.count==1) return cost;
            else return -1;

        }

        /**
         * use priorityqueue
         */
        class Union{
            int[] parents;
            int[] ranks;
            int count;
            Union(int N){
                count = N;
                parents = new int[N+1];
                ranks = new int[N+1];
                for(int i=1; i<N+1;i++){
                    parents[i]=i;
                    ranks[i] = 0;
                }
            }
            public int find(int node){
                if(parents[node]!=node){
                    parents[node]=find(parents[node]);
                }
                return parents[node];
            }
            public void unionSet(int x, int y){
                if(find(x)==find(y)) return;
                else{
                    if(ranks[x]<ranks[y]){
                        parents[find(x)] = find(y);
                    }else if(ranks[x]>ranks[y]){
                        parents[find(y)] =find(x);
                    }else{
                        parents[find(y)] = find(x);
                        ranks[x] += 1;
                    }
                    count --;
                }
            }
            public int count(){
                int c = 0;
                for(int i=1;i<parents.length;i++){
                    if(parents[i]==i){
                        c++;
                    }
                }
                return c;
            }

        }
    }
    static class Solution2 {
        public int minimumCost(int N, int[][] connections) {
            if(connections.length<N-1) return -1;
            int cost = 0;
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>((w1, w2)->w1.get(2)-w2.get(2));
            for(int i=0;i<connections.length;i++){
                List<Integer> edge = new ArrayList<>();
                for(int c: connections[i]){
                    edge.add(c);
                }
                pq.add(edge);
            }
            Union union = new Union(N);
            while(pq.size()!=0){
                List<Integer> edge = pq.poll();
                if(union.find(edge.get(0))==union.find(edge.get(1))){
                    continue;
                }
                union.unionSet(edge.get(0),edge.get(1));
                cost += edge.get(2);
                if(union.count==1){
                    break;
                }
            }
            int c = union.count();
            // return cost;
            if(union.count()==1) return cost;
            else return -1;

        }
        class Union{
            int[] parents;
            int[] ranks;
            int count;
            Union(int N){
                count = N;
                parents = new int[N+1];
                ranks = new int[N+1];
                for(int i=1; i<N+1;i++){
                    parents[i]=i;
                    ranks[i] = 0;
                }
            }
            public int find(int node){
                if(parents[node]!=node){
                    parents[node]=find(parents[node]);
                }
                return parents[node];
            }
            public void unionSet(int x, int y){
                if(find(x)==find(y)) return;
                else{
                    if(ranks[x]<ranks[y]){
                        parents[find(x)] = find(y);
                    }else if(ranks[x]>ranks[y]){
                        parents[find(y)] =find(x);
                    }else{
                        parents[find(y)] = find(x);
                        ranks[x] += 1;
                    }
                    count --;
                }
            }
            public int count(){
                int c = 0;
                for(int i=1;i<parents.length;i++){
                    if(parents[i]==i){
                        c++;
                    }
                }
                return c;
            }

        }
    }

    /**
     * Create Edge
     */
    static class Solution3 {
        public int minimumCost(int N, int[][] connections) {
            Edge[] edges = new Edge[connections.length];
            for (int i = 0; i < connections.length; i++) {
                int[] connection = connections[i];
                edges[i] = new Edge(connection[0], connection[1], connection[2]);
            }
            Arrays.sort(edges);
            int cost = 0;
            UnionFind unionFind = new UnionFind(N);
            for (Edge edge : edges) {
                if (unionFind.areConnected(edge.firstEnd, edge.secondEnd)) { continue; }
                unionFind.connect(edge.firstEnd, edge.secondEnd);
                cost += edge.weight;
                if (unionFind.componentCount == 1) { break; }
            }
            return unionFind.componentCount == 1 ? cost : -1;
        }

        private static class Edge implements Comparable<Edge> {
            int firstEnd;
            int secondEnd;
            int weight;

            Edge(int firstEdgeEnd, int secondEdgeEnd, int edgeWeight) {
                this.firstEnd = firstEdgeEnd;
                this.secondEnd = secondEdgeEnd;
                this.weight = edgeWeight;
            }

            public int compareTo(Edge that) {
                return this.weight - that.weight;
            }
        }

        private static class UnionFind {
            int[] parents;
            int componentCount;

            UnionFind(int elemCount) {
                parents = new int[elemCount + 1];
                for (int i = 0; i < parents.length; i++) {
                    parents[i] = i;
                }
                componentCount = elemCount;
            }

            boolean areConnected(int elem1, int elem2) {
                return getRoot(elem1) == getRoot(elem2);
            }

            void connect(int elem1, int elem2) {
                int root1 = getRoot(elem1);
                int root2 = getRoot(elem2);
                parents[root1] = root2;
                componentCount--;
            }

            int getRoot(int elem) {
                int parent = parents[elem];
                if (parent == elem) { return elem; }
                int root = getRoot(parent);
                parents[elem] = root;                   // path compression
                return root;
            }
        }
    }
}
