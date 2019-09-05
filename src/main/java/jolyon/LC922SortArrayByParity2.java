package com.leetcode.jolyon;

public class LC922SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i=0;i<A.length;i+=2){
            if(A[i]%2==1){
                while(A[j]%2==1){
                    j +=2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                j +=2;
            }
        }
        return A;
    }
}
