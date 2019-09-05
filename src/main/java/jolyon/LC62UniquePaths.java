package com.leetcode.jolyon;

public class LC62UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 0;
        int dp[] = new int[n];
        int dp2[] = new int[n];
        for(int k=0;k<n;k++) dp[k] =1;
        for(int i=1;i<m;i++){
            for(int j=0; j<n; j++){
                if(j==0){ dp2[j] =1;}
                else{
                    dp2[j] = dp2[j-1]+dp[j];
                }
            }
            dp = dp2;
        }
        return dp[n-1];

    }
}
