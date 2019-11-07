package com.leetcode.jolyon;

public class LC158ReadNCharactersGivenRead422 {
    public class Solution {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */

        private char[] buffer = new char[4];
        private int slowIndex = 0;
        private int fastIndex = 0;

        public int read(char[] buf, int n) {

            int numOfChar = 0;
            while(numOfChar < n) {
                // When two indices meet, fastIndex move forward 4 steps
                if(slowIndex == fastIndex) {
                    // reset our slow index
                    slowIndex = 0;
                    fastIndex = read4(buffer);
                    if(fastIndex == 0) {
                        break;
                    }
                }
                buf[numOfChar] = buffer[slowIndex];
                // SlowIndex always move forward 1 steps everytime.
                slowIndex++;
                numOfChar++;
            }

            return numOfChar;
        }
    }
    private static int read4(char[] buffer){
        return buffer.length;
    }
}
