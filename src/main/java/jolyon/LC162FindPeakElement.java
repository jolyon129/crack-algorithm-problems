package com.leetcode.jolyon;

public class LC162FindPeakElement {
    static class TerribleSolution {
        public int findPeakElement(int[] nums) {
            int head = nums[0];
            int tail = nums[nums.length - 1];
            if (nums.length == 2) {
                return nums[0] > nums[1] ? 0 : 1;
            }
            if (nums.length == 1) {
                return 0;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (mid == 0) {
                    if (nums[mid] > nums[mid + 1]) return 0;
                    else l = mid + 1;
                } else if (mid == nums.length - 1) {
                    if (nums[mid] > nums[mid - 1]) return nums.length - 1;
                    else r = mid - 1;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                    return mid;
                else if (nums[mid] > nums[mid - 1]) {
                    l = mid + 1;
                } else if (nums[mid] > nums[mid + 1]) {
                    r = mid - 1;
                } else if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    static class Solution {
        public int findPeakElement(int[] nums) {
            int head = nums[0];
            int tail = nums[nums.length - 1];
            if (nums.length == 2) {
                return nums[0] > nums[1] ? 0 : 1;
            }
            if (nums.length == 1) {
                return 0;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return r;
        }
    }
}
