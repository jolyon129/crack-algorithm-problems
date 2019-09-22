package com.leetcode.jolyon;

public class CitrixPhotoAlbum {
    int[] photoAlbum(int[] identity, int[] index) {
        int N = identity.length;
        int[] res = new int[N];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        int tail = -1;
        for (int i = 0; i < res.length; i++) {
            int idx = index[i];
            if(tail==-1) tail = idx + 1;
            if(res[idx]==-1){
                res[idx] = identity[i];
                tail = Math.max(tail, idx+1);
            }else{
                int j = tail;
                while (j>idx){
                    res[j] = res[j - 1];
                    j--;
                }
                tail++;
                res[idx + 1] = res[idx];
                res[idx] = identity[i];
            }
        }
        return res;
    }
}
