package com.leetcode.jolyon;

import java.util.Arrays;

public class LC322CoinChange {
    class RecursiveSolution{
        public int coinChange(int[] coins, int amount) {
            if(coins.length==0) return -1;
//            Arrays.sort(coins);
            Integer[] dp = new Integer[amount+1];
            return recur(coins, amount, dp);
        }
        private int recur(int[] coins, int amount, Integer[] dp){
            if(amount==0){
                return 0;
            }
            if(amount<0){
                return -1;
            }
            if(dp[amount]!=null){
                return dp[amount];
            }
            int tmp = -1;
            int min = Integer.MAX_VALUE;
            for(int i=coins.length-1;i>=0;i--){
                tmp= recur(coins, amount-coins[i], dp);
                if(tmp!=-1 &&tmp<min){
                    min = tmp;
                }
            }
            if(min!=Integer.MAX_VALUE) dp[amount] = min+1;
            else dp[amount] = -1;
            return dp[amount];
        }
    }
    class IterativeSolution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.sort(coins);
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j< coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }else{
                        break;
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
