package com.leetcode.jolyon;

public class LC63UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int H = obstacleGrid.length;
        int W = obstacleGrid[0].length;
        int[][] dp = new int[H][W];
        dp[0][0] = obstacleGrid[0][0]==1?0:1;
        for(int j=1;j<W;j++){
            dp[0][j] = obstacleGrid[0][j]==1?0:dp[0][j-1];
        }
        for(int i=1;i<H;i++){
            for(int j=0;j<W;j++){
                if(j==0){
                    dp[i][j] = obstacleGrid[i][j]==1?0:dp[i-1][j];
                }else{
                    dp[i][j]= obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[H-1][W-1];
    }
}
