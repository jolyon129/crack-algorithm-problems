package com.leetcode.jolyon;

public class LC10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp= new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<dp[0].length;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]= dp[0][i-2];
            }
            else{
                dp[0][i]= false;
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int x=i-1;
                int y=j-1;
                if(j==0) dp[i][j] = false;
                else{
                    if(dp[i-1][j-1]==true&&((s.charAt(x)==p.charAt(y))||p.charAt(y)=='.')){
                        dp[i][j]=true;
                    }else if(p.charAt(y)=='*'){
                        if(dp[i][j-2]==true){
                            dp[i][j]=true;
                        }else{
                            if(dp[i-1][j]==true&&(s.charAt(x)==p.charAt(y-1)||p.charAt(y-1)=='.')){
                                dp[i][j]=true;
                            }
                        }
                    }else{
                        dp[i][j] = false;
                    }
                }

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
