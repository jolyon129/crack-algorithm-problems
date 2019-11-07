package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//The idea is simple. G(i) = i^ (i/2).


// https://leetcode.wang/leetCode-89-Gray-Code.html

public class LC89GrayCode {
    public List<Integer> grayCodeDP(int n){
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i=0;i<n;i++){
            int size = res.size();
            for(int j=size-1;j>=0;j--){
                res.add(res.get(j) | 1 << i);
            }
        }
        return res;
    }
    public List<Integer> grayCodeUsingFormular(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
