package com.leetcode.jolyon;

public class GoogleWateringFlowers {
    //w, 2, 4, 5, 2, 3
    //w, 3
    public int solution(int[] plants, int capacity) {
        // write your code in Java SE 8
        int can = capacity;
        int steps = 0;
        for(int i=-1;i<plants.length-1;i++){
            if(can>=plants[i+1]){
                steps++;
                can -= plants[i+1];
            }else{
                steps += 2*(i-(-1))+1;
                can = capacity-plants[i+1];
            }
        }
        return steps;
    }
}
