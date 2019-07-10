package edu.nyu.jolyon;

import java.util.Random;

/**
 * LC_215
 */
public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        int k_smallest = nums.length - (k); 
        return quickSelect(0, nums.length, nums, k_smallest);
    }

    public int quickSelect(int low, int high, int[] nums, int k_idx) {
        if (low == high-1) {
            return nums[low];
        }
        Random random = new Random();
        int part_idx = random.nextInt(high-low)+low;
        part_idx = partion(low, high, nums, part_idx);
        if (part_idx == k_idx) {
            return nums[part_idx];
        }else if(part_idx<k_idx){
            return quickSelect(part_idx+1, high, nums, k_idx);
        }else{
            return quickSelect(low, part_idx-1, nums, k_idx);
        }
    }

    public int partion(int lo, int hi, int[] nums,int part_idx) {
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

    public static void main(String[] args) {
        var sol = new LC_215();
        int[] nums = {99,99};
        var t = sol.findKthLargest(nums, 1);
        System.out.println(t);
    }
}
