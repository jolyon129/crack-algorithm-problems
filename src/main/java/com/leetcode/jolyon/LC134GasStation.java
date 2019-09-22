package com.leetcode.jolyon;

public class LC134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas =0;
        int total_cost =0;
        int current_gas=0;
        int current_cost=0;
        int idx=0;
        int start = 0;
        while (idx < gas.length) {
            total_gas += gas[idx];
            total_cost += cost[idx];
            current_cost += cost[idx];
            current_gas += gas[idx];
            if(current_cost>current_gas){
                current_cost = 0;
                current_gas = 0;
                start = idx + 1;
            }
            idx++;
        }
        if(total_cost>total_gas) return -1;
        else{
            return start;
        }

    }
}
