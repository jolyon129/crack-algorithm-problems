package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC957PrisonCellsAfterNDays {
    /**
     * The optimal solution
     */
    static class Solution {
        public int[] prisonAfterNDays(int[] cells, int N) {
            Set<Integer> seen = new HashSet<>();
            int[] current =cells;
            int steps = 0;
            seen.add(toInt(cells));
            boolean hasCycle = false;
            for(int n=0;n<N;n++){
                current = nextDay(current);
                steps++;
                if(seen.contains(toInt(current))){
                    hasCycle = true;
                    break;
                }
                seen.add(toInt(current));
            }
            if(!hasCycle){
                return current;
            }else{
                int startofCycle = toInt(current);
                int count = 1;
                int[] start =nextDay(current);
                while(toInt(start)!=startofCycle){
                    count ++;
                    start = nextDay(start);
                }
                int anotherSteps = (N-(steps-count)) % count;
                start = current;
                while(anotherSteps>0){
                    start = nextDay(start);
                    anotherSteps --;
                }
                return start;
            }
        }
        private int[] nextDay(int[] cells){
            int[] next = new int[cells.length];
            for(int i=1;i<cells.length-1;i++){
                next[i] = cells[i-1]==cells[i+1]?1:0;
            }
            next[0]=0;
            next[cells.length-1]=0;
            return next;
        }
        private int toInt(int[] cells){
            int nums = 0;
            for(int t:cells){
                nums = nums*10+t;
            }
            return nums;
        }
    }
    /**
     * This is not optimal solution
     * The days N is within (1,10^9)
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
     * This is not optimal solution
     * The days N is within (1,10^9)
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
                    seen.put(current,next);
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
