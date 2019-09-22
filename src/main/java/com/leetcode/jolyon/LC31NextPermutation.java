package com.leetcode.jolyon;

public class LC31NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int N = nums.length;
        int i1 = N - 2;
        while (i1 >= 0 && nums[i1] >= nums[i1 + 1]) {
            i1--;
        }
        if (i1 == -1) {
            for (int i = 0, j = N - 1; i <= j; i++, j--) {
                swap(nums, i, j);
            }
        } else {
            int i2 = N - 1;
            while (i2 >= 0 && nums[i2] <= nums[i1]) {
                i2--;
            }

            swap(nums, i1, i2);
            for (int i = i1 + 1, j = N - 1; i <= j; i++, j--) {
                swap(nums, i, j);
            }

        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
