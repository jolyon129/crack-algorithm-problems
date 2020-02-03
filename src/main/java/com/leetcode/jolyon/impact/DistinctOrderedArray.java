package com.leetcode.jolyon.impact;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DistinctOrderedArray {
    /**
     * I'm using bucket sort here. Assume the numbers are 32-bit long. Count
     * much faster when the range of the numbers is relatively small. Assuming
     * the range is `R`, and the size of input is 'N', then the time complexity
     * should be O(max(R,N)). The space complexity is O(N)
     *
     * @param arr input
     * @return return an arr of sorted distinct numbers
     */
    static int[] generateSortedDistinctArr(int[] arr) {
        if (arr.length <= 1) return arr;
        Map<Integer, Integer> buckets = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            buckets.put(num, buckets.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[buckets.keySet().size()];
        int idx = 0;
        for (int i = min; i <= max; i++) {
            if (!buckets.keySet().contains(i)) {
                continue;
            }
            result[idx++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 5, 2, 2, 3, 3, 1};
        int[] ans = generateSortedDistinctArr(arr);

        System.out.print(Arrays.stream(ans)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" , ")));
    }
}
