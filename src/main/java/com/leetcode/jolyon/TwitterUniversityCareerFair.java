package com.leetcode.jolyon;

import java.util.Arrays;

public class TwitterUniversityCareerFair {
    public int maxEvents(int[] arrivals, int[] duration){
        int[][] finish = new int[arrivals.length][2];
        for(int i=0;i<arrivals.length;i++){
            finish[i][0] = i;
            finish[i][1] = arrivals[i] + duration[i];
        }
        Arrays.sort(finish, (c1, c2) -> {
            return Integer.compare(c1[1], c2[1]);
        });
        int prevFinish = 0;
        int count = 0;
        for (int i = 0; i < finish.length;i++) {
            int idx = finish[i][0];
            if(arrivals[idx]>=prevFinish){
                count++;
                prevFinish = finish[i][1];
            }
        }
        return count;
    }
}
