package com.leetcode.jolyon;

import java.util.Map;
import java.util.TreeMap;

public class LC975OddEvenJump {
    public int oddEvenJumps(int[] A) {
        /**
         * 10, 13, 12, 14, 15
         *
         */
        // odd
        // even
        if(A.length==1) return 1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[A.length-1], A.length-1);
        boolean[] odd = new boolean[A.length];
        boolean[] even = new boolean[A.length];
        odd[A.length - 1] = true;
        even[A.length - 1] = true;
        for(int i=A.length-2;i>=0;i--){
            if(treeMap.containsKey(A[i])){
                odd[i] = even[treeMap.get(A[i])];
                even[i] = odd[treeMap.get(A[i])];
            }else{
                Map.Entry<Integer, Integer> e1 = treeMap.ceilingEntry(A[i]);
                Map.Entry<Integer, Integer> e2 = treeMap.floorEntry(A[i]);
                if(e1!=null){
                    odd[i] = even[e1.getValue()];
                }
                if(e2!=null){
                    even[i] = odd[e2.getValue()];
                }
            }

            treeMap.put(A[i], i);
        }
        int count =0;
        for(int i =0;i<A.length;i++){
            if(odd[i]) count++;
        }
        return count;
    }
}
