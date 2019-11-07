package com.leetcode.jolyon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC957PrisonCellsAfterNDays {
    /**
     * The optimal solution
     */

    /**
     * That's purely because we will NEVER ALWAYS reach the same state as on!
     *
     * A very good question indeed.
     * The explanation below is entirely based on the solution provided in this comment.
     * To understand why we did not set the initial state into the set before the loop, let's assume we were supposed to perform N=23 operations.
     *
     * After performing operation number 1, it reaches a state say X. We store this state in set.
     * Assume, after performing 6th operation it again reaches state X . So we now know that the it takes (6-1) = 5 operations to attain the same state X, which in turn means , after every 5 operations, it would reach the same state.
     * Now, that we know 5 is the cycle count, we need perform 13 % 5 = 3 operations more. ( NOTE : We did not update the cells to next when we found the cycle on the 6th operation. So we need to perform the sixth operation again. )
     * In the final go, we perform just 3 more operations to complete the whole cycle.
     * Hope this helps :)
     */
    static class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            if(cells==null || cells.length==0 || N<=0) return cells;
            boolean hasCycle = false;
            int lengthOfCycle = 0;
            // We will not always hit Day Zero  twice, especially when the last
            // cell is 1 on day Zero. So our cycle starts on Day One instead
            // of Day Zero!
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<N;i++){
                int[] next = nextDay(cells);
                String key = Arrays.toString(next);
                if(!set.contains(key)){ //store cell state
                    set.add(key);
                    lengthOfCycle++;
                }
                else{ //hit a cycle
                    hasCycle = true;
                    break;
                }
                // IMPORTANT!
                cells = next;
            }
            if(hasCycle){
                N%=lengthOfCycle;
                for(int i=0;i<N;i++){
                    cells = nextDay(cells);
                }
            }
            return cells;
        }

        private int[] nextDay(int[] cells){
            int[] tmp = new int[cells.length];
            for(int i=1;i<cells.length-1;i++){
                tmp[i]=cells[i-1]==cells[i+1]?1:0;
            }
            return tmp;
        }
    }

    /**
     * This is not optimal solution The days N is within (1,10^9)
     */
    static class Solution1 {
        public int[] prisonAfterNDays(int[] cells, int N) {
            int[] prev = cells;
            int[] curr = new int[cells.length];
            for (int n = 1; n < N + 1; n++) {
                for (int i = 1; i < cells.length - 1; i++) {
                    curr[i] = prev[i - 1] == prev[i + 1] ? 1 : 0;
                }
                curr[0] = 0;
                curr[cells.length - 1] = 0;
                for (int i = 0; i < curr.length; i++) {
                    prev[i] = curr[i];
                }
            }
            return curr;
        }
    }

    /**
     * This is not optimal solution The days N is within (1,10^9)
     */
    static class Solution2 {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Map<String, String> seen = new HashMap<>();
            String current = "";
            for (int i : cells) {
                current = current + String.valueOf(i);
            }
            String next = "";
            for (int i = 0; i < N; i++) {
                if (seen.containsKey(current)) {
                    next = seen.get(current);
                } else {
                    next = next(current);
                    seen.put(current, next);
                }
                current = next;
            }
            int[] res = new int[next.length()];
            for (int i = 0; i < next.length(); i++) {
                res[i] = next.charAt(i) - '0';
            }
            return res;
        }

        private String next(String current) {
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            for (int i = 1; i < current.length() - 1; i++) {
                if (current.charAt(i - 1) == current.charAt(i + 1))
                    sb.append('1');
                else sb.append('0');
            }
            sb.append('0');
            return sb.toString();
        }

    }


}
