package com.leetcode.jolyon.amazon;

public class LC75SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                // Advance cur!
                swap(nums, p0++, cur++);
            } else if (nums[cur] == 2) {
                // Don't advance cur!
                swap(nums, p2--, cur);
            } else {
                cur++;
            }

        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
