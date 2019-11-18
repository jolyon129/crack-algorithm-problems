package com.leetcode.jolyon;

public class LC91DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) - '0' == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        // IMPORTANT! If no input, we should return at least one.
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<s.length()+1;i++){
            int idx = i - 1;
            char cur = s.charAt(idx);
            char prev = s.charAt(idx - 1);
            // "00"
            if((prev-'0')*10+(cur-'0')==0) return 0;
            // "11"
            if(prev-'0'>0&&(prev-'0')*10+(cur-'0')<=26){
                dp[i] += dp[i - 2];
            }
            // "10"
            if(cur-'0'!=0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
