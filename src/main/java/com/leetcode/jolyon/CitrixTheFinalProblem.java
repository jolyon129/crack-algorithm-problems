package com.leetcode.jolyon;

public class CitrixTheFinalProblem {
    /*
     * Complete the 'theFinalProblem' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING target as parameter.
     */

    public static int theFinalProblem(String target) {
        boolean isFlip = false;
        int count = 0;
        for(int i =0;i<target.length();i++){
            if(target.charAt(i) =='1'&&isFlip==false){
                count++;
                isFlip = true;
            }else if(target.charAt(i)=='0'&&isFlip==true){
                count++;
                isFlip = false;
            }
        }
        return count;
    }
}
