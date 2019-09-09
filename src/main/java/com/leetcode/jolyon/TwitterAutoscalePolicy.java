package com.leetcode.jolyon;

public class TwitterAutoscalePolicy {
    public int process(int[] u, int start){
        int res = start;
        for(int i=0;i<u.length;i++){
            if(u[i]<25){
                if(res >1){
                    res = (int)Math.ceil(res / 2);
                    i += 10;
                }
            }else if(u[i]>60){
                if(res< 1_000_000_00){
                    res = res * 2;
                    i += 10;
                }
            }
        }
        return res;
    }
}
