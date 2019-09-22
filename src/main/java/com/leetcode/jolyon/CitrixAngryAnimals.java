package com.leetcode.jolyon;

import java.util.List;

public class CitrixAngryAnimals {
    public int countGroups(int n, List<Integer> a, List<Integer> b) {
        int M = a.size();
        int N = n;
        int[][] dp = new int[N+1][N+1];
        int[][] matrix = new int[N+1][N+1];
        for(int i =0;i<=N;i++){
            dp[i][i] = 1;
        }
        for(int i=0;i<M;i++){
            int x = a.get(i);
            int y = b.get(i);
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }
        for(int l=1;l<N;l++){
            for(int i=1;i<=N-l;i++){
                int j = l + i;
                if(matrix[i][j]!=1&&dp[i][j-1]==1&&dp[i+1][j]==1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int count = 0;
        for(int i=1;i<=N;i++){
            for(int j =i;j<=N;j++){
                if(dp[i][j]==1){
                    System.out.println(i+" "+j);
                    count++;
                }

            }
        }
        return count;
    }



}
