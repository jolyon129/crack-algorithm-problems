package com.leetcode.jolyon;

import java.util.Arrays;

public class LC646MaximumLengthofPairChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (int[] w1, int[] w2)->{
                if(w1[1]!=w2[1]){
                    return Integer.compare(w1[1],w2[1]);
                }else{
                    return Integer.compare(w1[0],w2[0]);
                }
            });
            int count =1;
            // int starting = pairs[0][0];
            int ending = pairs[0][1];
            for(int i=1;i<pairs.length;i++){
                if(pairs[i][0]>ending){
                    count++;
                    // starting = pairs[i][0];
                    ending = pairs[i][1];
                }
            }
            return count;
        }
    }
}
