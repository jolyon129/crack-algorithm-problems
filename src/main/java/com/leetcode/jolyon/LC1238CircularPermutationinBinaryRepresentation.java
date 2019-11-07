package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.List;

public class LC1238CircularPermutationinBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list1 = new ArrayList<>();
        int iter = 0;
        for (; ; iter++) {
            int tmp = iter ^ (iter >> 1);
            if (tmp == start) break;
            list1.add(tmp);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int b = iter; b < (1 << n); b++) {
            list2.add(b ^ (b >> 1));
        }
        list2.addAll(list1);
        return list2;

    }
}
