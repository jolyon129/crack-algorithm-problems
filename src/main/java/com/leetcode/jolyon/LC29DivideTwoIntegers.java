package com.leetcode.jolyon;

public class LC29DivideTwoIntegers {
    static class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend==Integer.MIN_VALUE && divisor == -1){
                return Integer.MAX_VALUE;
            }
            if(dividend==Integer.MIN_VALUE && divisor == 1){
                return Integer.MIN_VALUE;
            }
            // abs has a risk of overflow, when input is Integer.MIN_VALUE
            int a = Math.abs(dividend);
            int b = Math.abs(divisor);
            int res = 0;
            while(a-b>=0){
                int k=0;
                // How many b*2*2.. we can take from a at a time.
                while(a-(b<<k)>=0){
                    k++;
                }
                // we can ke 2^(k-1) times b from a, so add res by 2^(k-1)
                res += 1<<(k-1);
                a -= b<<(k-1);

            }
            return ((dividend>0)==(divisor>0))?res:-res;
        }
    }
}
