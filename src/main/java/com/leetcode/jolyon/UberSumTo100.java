package com.leetcode.jolyon;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/357345/uber-phone-screen-sum-to-100
 */
public class UberSumTo100 {
    public List<String> sumTo100() {
        List<String> result = new ArrayList<>();
        char[] nums = new char[9];
        for(int i=0;i<9;i++){
            nums[i]= (char) (i + 1 + '0');
        }
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder(); 
        dfs(0,0,res,nums,path);
        return res;
    }

    private void dfs(int start, int sum, List<String> res,
                     char[]nums, StringBuilder path) {
        if (sum == 100 && start == nums.length) {
            res.add(path.toString());
            return;
        }
        if(start>=nums.length){
            return;
        }
        StringBuilder tmp = new StringBuilder();
        int len = path.length();
        for (int i = start; i<nums.length;i++) {
            tmp.append(nums[i]);
            int n = Integer.parseInt(String.valueOf(tmp));
            if(start!=0) path.append("+");
            path.append(n);
            dfs(i + 1,sum+n, res, nums, path);
            path.setLength(len);
            // You actually can start with minus 1 !!!!!
            path.append("-");
            path.append(n);
            dfs(i + 1, sum- n, res, nums, path);
            path.setLength(len);
        }
        
    }
}
