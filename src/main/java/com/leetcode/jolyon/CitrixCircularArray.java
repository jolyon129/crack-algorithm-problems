package com.leetcode.jolyon;

public class CitrixCircularArray {
    int circularArray(int n, int m, int[] endNode) {
        int[] count = new int[n + 1];
        for (int i = 0; i < m-1; i++) {
            int start = endNode[i];
            int end = endNode[i + 1];
            while (start != end) {
                count[start]++;
                if(start==n){
                    start = 1;
                }else{
                    start++;
                }
            }
            count[end]++;
        }
        int max=0;
        int optNum=n+1;
        for(int i=1;i<=n;i++){
            if(count[i]>max){
                optNum = i;
                max = count[i];
            }else if(count[i]==max){
                optNum = Math.min(i, optNum);
            }
        }
        return optNum;
    }
}
