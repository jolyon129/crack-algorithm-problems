package com.leetcode.jolyon;

public class FactualOA1 {
    public double solution(double[][] readings, long endTime) {
        double ratio = 60 * 60;
        double res = 0;
        for (int i = 0; i < readings.length;i++) {
            if(i==readings.length-1){
                res += (endTime - readings[i][0]) * readings[i][1];
                continue;
            }
            res += (readings[i + 1][0] - readings[i][0]) * readings[i][1];
        }
        return res/ratio;
    }
}
