package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        /**
         * The length of LIS should equal to the number of piles.
         */
        List<Integer> piles = new ArrayList<>();
        for (int num : nums) {
            // for each num, try to find the leftmost pile that can fit,
            // where the top of the element should greater than the current one
            if(piles.size()==0){
                piles.add(num);
                continue;
            }
            // Return the first idx that the element is greater or equal to
            // the target
            int i = Collections.binarySearch(piles, num);
            if(i<0) i = -(i + 1);
            // If none of the pile can fit the num, add a new pile
            if(i==piles.size()){
                piles.add(num);
            }else{
                piles.set(i, num);
            }
        }
        return piles.size();
    }

}
