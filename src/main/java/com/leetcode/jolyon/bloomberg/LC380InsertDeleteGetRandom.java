package com.leetcode.jolyon.bloomberg;

import java.util.*;

public class LC380InsertDeleteGetRandom {
    class RandomizedSet {
        HashMap<Integer, Integer> valToIdx;
        List<Integer> list;
        int ind = 0;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            valToIdx = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(valToIdx.containsKey(val)) return false;
            list.add(val);
            valToIdx.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            int ind = valToIdx.getOrDefault(val,-1);
            if(ind == -1) return false;
            Collections.swap(list,ind,list.size()-1);
            int swappedWith = list.get(ind);
            // Update the table
            valToIdx.put(swappedWith,ind);
            // remove the last one
            list.remove(list.size()-1);
            // remove the val in hashmap
            valToIdx.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int max = list.size();
            Random rd = new Random();
            int ind = rd.nextInt(max);
            return list.get(ind);
        }
    }
}
