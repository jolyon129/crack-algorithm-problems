package com.leetcode.jolyon.amazon;

public class LC34FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int start = l;
        if (start >= nums.length || nums[start] != target)
            return new int[]{-1, -1};
        l = start;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target || nums[mid] == target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int end = l - 1;
        return new int[]{start, end};
    }
}
