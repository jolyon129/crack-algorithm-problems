package com.leetcode.jolyon.bloomberg;

public class LC33SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int tail = nums.length - 1;
        if (nums.length == 0) return -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (left == right) {
                if (target != nums[left]) return -1;
                else return left;
            }
            if (nums[mid] > nums[tail]) {  // eg. 3,4,5,6,1,2
                if (target > nums[mid] || target <= nums[tail]) {
                    // target and mid on same part but target greater than
                    // mid; or target and mid on different parts
                    left = mid + 1;
                } else {
                    // target and mid on same parts
                    right = mid;
                }
            } else {  // eg. 5,6,1,2,3,4
                if (target > nums[mid] && target <= nums[tail]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return left;
    }

}
