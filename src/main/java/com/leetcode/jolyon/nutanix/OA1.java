package com.leetcode.jolyon.nutanix;

public class OA1 {
    int solve(int[] arr){
        int N = arr.length;
        int[] dp = new int[N];
        int[] zeros = new int[N];
        zeros[0] = arr[0] == 0 ? 1 : 0;
        dp[0] = arr[0] == 0 ? 1 : 0;
        for(int i=1;i<N;i++){
            zeros[i] = (arr[i] == 0) ? zeros[i - 1] + 1 : 0;
            if(arr[i]==1){
                if(zeros[i-1]==i) dp[i] = 1;
                else{
                    dp[i] = dp[i - 1] * (zeros[i - 1] + 1);
                }
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        OA1 sol = new OA1();
        int ans = sol.solve(new int[]{0, 0, 0, 1, 0, 1});
        System.out.println(ans);
    }
}
