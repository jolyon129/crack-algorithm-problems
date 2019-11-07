package com.leetcode.jolyon.quora;

import java.util.HashSet;
import java.util.Set;

public class GoodTuple {
    int solve(int[] input) {
        Set<Integer> window = new HashSet<>();
        int i=0;
        while (i<3){
            window.add(input[i]);
            i++;
        }
        int count =0;
        if(window.size()==2) count++;
        for(;i<input.length;i++){
            window.remove(input[i - 3]);
            window.add(input[i]);
            if(window.size()==2) count++;
        }
        return count;
    }
}
