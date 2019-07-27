package edu.nyu.jolyon;

import java.util.*;

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
        private int[] sets;
        DSU(int num){
            ranks = new int[num];
            sets = new int[num];
            for(int i=0; i<num;i++){
                sets[i]=i;
                ranks[i]=0;
            }
        }
        public void union(int x, int y){
            if(find(x)==find(y)) return;
            else{
                if(ranks[x]<ranks[y]){
                    sets[find(x)] = y;
                }else if(ranks[x]>ranks[y]){
                    sets[find(y)] = x;
                }else{
                    sets[find(y)] = x;
                    ranks[x] += 1;
                }
            }
        }
        public int find(int x){
            if(sets[x]!=x){
                sets[x] = find(sets[x]);
            }
            return sets[x];
        }
        public int count(){
            int c = 0;
            for(int i=0;i<sets.length;i++){
                if(sets[i]==i){
                    c++;
                }
            }
            return c;
        }
    }
}
