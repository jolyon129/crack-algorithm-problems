package com.leetcode.jolyon;

public class LC1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int N = A.length;
        int D =6;
        int[] AFreq = new int[D+1];
        int[] BFreq = new int[D+1];
        int[] freq = new int[D+1];
        for(int i=0;i<N;i++){
            int n1 = A[i];
            int n2 = B[i];
            freq[n1]++;
            if(n1!=n2) freq[n2]++;
            AFreq[n1]++;
            BFreq[n2]++;
        }
        if(freq[A[0]]==N){
            return Math.min(N-AFreq[A[0]], N-BFreq[A[0]]);
        }else if(freq[B[0]]==N){
            return Math.min(N-AFreq[B[0]],N-BFreq[B[0]]);
        }else{
            return -1;
        }
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int target1 = A[0];
        int target2 = A[1];
        int ans = flip(target1, A, B);
        if (ans > -1) return ans;
        else {
            return flip(target2, A, B);
        }

    }

    int flip(int target, int[] A, int[] B) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) return -1;
            if (A[i] != target) {
                n1++;
            }
            if (B[i] != target) {
                n2++;
            }

        }
        return Math.min(n1, n2);
    }
}
