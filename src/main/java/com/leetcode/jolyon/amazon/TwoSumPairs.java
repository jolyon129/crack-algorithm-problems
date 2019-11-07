package com.leetcode.jolyon.amazon;

import java.util.HashSet;
import java.util.Set;

public class TwoSumPairs {
    public static int uniquePairs(int[] ratingValues, int target){
        Set<Integer> components = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for(int num : ratingValues){
            if(components.contains(target-num) && !seen.contains(num)){
                count++;
                seen.add(target-num);
                seen.add(num);
            }
            else if(!components.contains(num)){
                components.add(num);
            }

        }

        return count;
    }

}
