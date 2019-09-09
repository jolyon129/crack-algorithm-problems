package com.leetcode.jolyon;

public class TwitterWeirdFaculty {
    public int ans(int[] v) {
        int[] leftSum = new int[v.length + 1];
        int[] rightSum = new int[v.length + 1];
        leftSum[0] = 0;
        rightSum[rightSum.length - 1] = 0;
        for (int i = 0; i < v.length; i++) {
            leftSum[i + 1] = leftSum[i] + (v[i] == 1  ? 1 : -1);
        }
        for(int i= v.length-1;i>=0;i--){
            rightSum[i] = rightSum[i + 1] + (v[i] == 1 ? 1 : -1);
        }
        int res = 0;
        for(int i =0;i<v.length+1;i++){
            if(leftSum[i]>rightSum[i]){
                res =  i;
                break;
            }
        }
        return res;
    }
}
