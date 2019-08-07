package com.leetcode.jolyon;

public class LC959ReginsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        final int N = grid.length;
        DSU dsu = new DSU(4*N*N);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int root = i*4*N+4*j;
                if(grid[i].charAt(j)==' '){
                    dsu.union(root,root+1);
                    dsu.union(root,root+2);
                    dsu.union(root,root+3);
                }else if(grid[i].charAt(j)=='/'){
                    dsu.union(root, root+3);
                    dsu.union(root+1, root+2);
                }else if(grid[i].charAt(j)=='\\'){
                    dsu.union(root, root+1);
                    dsu.union(root+2, root+3);
                }
                if(j<N-1){
                    int r_root = i*4*N+4*(j+1);
                    dsu.union(root+1,r_root+3);
                }
                if(i<N-1){
                    int b_root = (i+1)*4*N+4*j;
                    dsu.union(root+2,b_root);
                }

            }
        }
        return dsu.count();
    }
    public class DSU{
        private int[] ranks;
        private int[] parents;
        DSU(int num){
            ranks = new int[num];
            parents = new int[num];
            for(int i=0; i<num;i++){
                parents[i]=i;
                ranks[i]=0;
            }
        }
        public void union(int x, int y){
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
            }
        }
        public int find(int x){
            if(parents[x]!=x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        public int count(){
            int c = 0;
            for(int i = 0; i< parents.length; i++){
                if(parents[i]==i){
                    c++;
                }
            }
            return c;
        }
    }
}
