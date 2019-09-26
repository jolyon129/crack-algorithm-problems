package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC554BrickWall {
    // List<List<Interger>> wall -> int leastnumber
    // not 0, scribble
    // ------|-----|
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> freqOfSum = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size()-1; j++) {
                sum += wall.get(i).get(j);
                freqOfSum.put(sum, freqOfSum.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = Integer.MAX_VALUE;
        int H = wall.size();
        if(freqOfSum.isEmpty()) return wall.size();
        for(Integer v: freqOfSum.values()){
            ans = Math.min(H - v,ans);
        }
        return ans;
    }
}
