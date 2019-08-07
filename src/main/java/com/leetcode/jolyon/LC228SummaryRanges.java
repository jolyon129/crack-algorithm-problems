package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        int start=0;
        int end = 0;
        int i = 0;

        while (i < nums.length) {
            start = i;
            while (i+1<nums.length && nums[i+1] - nums[i] == 1) {
                end = i+1;
                i += 1;
            }
            if(start == end){
                result.add(nums[start]+"");
            }else {
                result.add(nums[start] + "->" + nums[end]);
            }
            i += 1;
            end = i;
        }
        return result;
    }
}
