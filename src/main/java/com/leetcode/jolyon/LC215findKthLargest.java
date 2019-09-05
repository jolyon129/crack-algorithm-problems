package com.leetcode.jolyon;

import java.util.Random;

/**
 * LC215findKthLargest
 */
public class LC215findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int k_smallest = nums.length - (k);
        return quickSelect(0, nums.length, nums, k_smallest);
    }

    public int quickSelect(int low, int high, int[] nums, int k_idx) {
        if (low >= high-1) {
            return nums[low];
        }
        Random random = new Random();
        int part_idx = random.nextInt(high-low)+low;
        part_idx = partition(low, high, nums, part_idx);
        if (part_idx == k_idx) {
            return nums[part_idx];
        }else if(part_idx<k_idx){
            return quickSelect(part_idx+1, high, nums, k_idx);
        }else{
            return quickSelect(low, part_idx, nums, k_idx);
        }
    }


    public int partition(int lo, int hi, int[] nums,int part_idx) {
        int tmp = nums[hi - 1];
        nums[hi - 1] = nums[part_idx];
        nums[part_idx] = tmp;
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (nums[j] < nums[hi-1]) {
                i = i + 1;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        tmp = nums[hi-1];
        nums[hi-1] = nums[i + 1];
        nums[i + 1] = tmp;
        return i + 1;
    }
}
