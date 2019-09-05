package com.leetcode.jolyon;

public class LC1154 {
    static class Solution {
        public int dayOfYear(String date) {
            String[] infos = date.split("-");
            int tmp = Integer.parseInt(infos[0]);
            int feb;
            if ((tmp % 4 == 0 && tmp % 100 != 0) || (tmp % 100 == 0 && tmp % 400 == 0)) {
                feb = 29;
            } else {
                feb = 28;
            }

            int[] months = new int[]{31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int m = Integer.parseInt(infos[1]);
            int res = 0;
            for (int i = 0; i < m - 1; i++) {
                res += months[i];
            }
            return res + Integer.parseInt(infos[2]);
        }
    }
}
