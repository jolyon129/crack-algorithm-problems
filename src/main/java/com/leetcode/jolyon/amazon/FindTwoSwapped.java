package com.leetcode.jolyon.amazon;

import java.util.Arrays;
import java.util.List;

public class FindTwoSwapped {
    static public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                // This can handle the situation when there two swapped
                // elements are consecutive
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        var ans = findTwoSwapped(List.of(3, 1));
        System.out.println(Arrays.toString(ans));
    }
}
