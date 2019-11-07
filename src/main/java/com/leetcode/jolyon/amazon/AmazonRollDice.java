package com.leetcode.jolyon.amazon;

/**
 * https://leetcode.com/discuss/interview-question/331158/amazon-online-assessment-2019-roll-dice
 *
 */
public class AmazonRollDice {
    public static class Solution{
        public int minSteps(int[] A){
            int res = Integer.MAX_VALUE;
            for(int i=1;i<7;i++){
                int count = 0;
                for(int d:A){
                    if(d+i==7){
                        count+=2;
                    }else if(d==i){
                        continue;
                    }else{
                        count += 1;
                    }
                }
                res = Math.min(count,res);
            }
            return res;
        }
    }
}
