package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LC349IntersectionofTwoArrays {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for(int n:nums1){
                set1.add(n);
            }
            for(int n:nums2){
                set2.add(n);
            }
            ArrayList<Integer> res = new ArrayList<>();
            for(int s:set1){
                if(set2.contains(s)) res.add(s);
            }
            int[] r = new int[res.size()];
            for(int i=0;i<res.size();i++){
                r[i] = res.get(i);
            }
            return r;
        }
    }
}
