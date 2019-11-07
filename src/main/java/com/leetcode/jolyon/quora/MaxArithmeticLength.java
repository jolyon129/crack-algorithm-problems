package com.leetcode.jolyon.quora;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Suppose we have array a and b (no duplicates & sorted) a = [0,4,8,20] b =
 * [5,7,12,16,22]
 * <p>
 * Suppose u can pick any number of element from b (could be 0), and u want to
 * insert them into array a such that all elements in a are increasing by
 * certain number, so in this example u can pick "12, 16" from b and append into
 * a such that a = [0,4,8,12,16,20], which increase by 4 for each element
 * <p>
 * write a function to return the maximum number of element in a after appending
 * elements from b (in the exmaple above the result is 6), if there is no such
 * case, return -1
 */

public class MaxArithmeticLength {
    int solve(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int n : a) setA.add(n);
        int[] arr = merge(a, b);
        Map<Integer, Integer>[] diffMaps = new Map[arr.length];
        // At index i, how many number of digits from setA have been visited
        // in subsequence ending at this index.
        Map<Integer, Integer>[] countMaps = new Map[arr.length];
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            diffMaps[i] = new HashMap<>();
            countMaps[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                if (diffMaps[j].containsKey(diff)) {
                    diffMaps[i].put(diff, diffMaps[j].get(diff) + 1);
                } else {
                    diffMaps[i].put(diff, 2);
                }
                int pre; // how many number we have seen before j.
                if (j == 0 && setA.contains(arr[0])) {
                    pre = 1;
                } else {
                    pre = countMaps[j].getOrDefault(diff, 0);
                }
                if (setA.contains(arr[i])) {
                    countMaps[i].put(diff, pre + 1);
                } else {
                    countMaps[i].put(diff, pre);
                }
                if (countMaps[i].get(diff) == setA.size()) {
                    ans = Math.max(ans, diffMaps[i].get(diff));
                }

            }
        }
        return ans;
    }


    int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        int x = 0;
        int N = a.length;
        int M = b.length;
        int[] arr = new int[a.length + b.length];
        while (i < N && j < M) {
            if (a[i] < b[j]) {
                arr[x] = a[i];
                x++;
                i++;
            } else {
                arr[x] = b[j];
                x++;
                j++;
            }
        }
        while (i < N) {
            arr[x] = a[i];
            i++;
            x++;
        }
        while (j < M) {
            arr[x] = b[j];
            j++;
            x++;
        }
        return arr;
    }
}
