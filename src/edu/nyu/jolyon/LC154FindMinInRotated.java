package edu.nyu.jolyon;

public class LC154FindMinInRotated {
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length==1) return nums[0];
            int lo = 0, hi = nums.length - 1;
            while (lo < hi) {
                while (lo < hi && nums[lo] == nums[hi]) {
                    lo++;
                }
                int mid = (hi - lo) / 2 + lo;
                if (nums[mid] > nums[hi]) lo = mid + 1;
                else {
                    hi = mid;
                }
            }
            return nums[lo];
        }
    }
}
