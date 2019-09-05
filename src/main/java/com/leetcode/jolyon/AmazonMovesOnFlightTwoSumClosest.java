package com.leetcode.jolyon;

import java.util.Arrays;

public class AmazonMovesOnFlightTwoSumClosest {
    public int[] twoSumClosest(int movies[], int duration){
        Arrays.sort(movies);
        int l = 0;
        int r = movies.length-1;
        int optimal=-1;
        int[] res = new int[2];
        while (l<r){
            int sum = movies[l] + movies[r];
            if(sum<duration-30){
                if (sum >optimal) {
                    optimal = sum;
                    res[0]= l;
                    res[1] = r;
                }
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
