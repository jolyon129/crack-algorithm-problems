package com.leetcode.jolyon.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239SlidingWindowMaximum {
    static class UsingDeque {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums.length*k==0) return new int[0];
            // Monotone Decreasing Deque
            // only store the idex!
            Deque<Integer> dq = new ArrayDeque<>();
            int[] output = new int[nums.length-k+1];
            for(int i=0;i<nums.length;i++){
                // Already Full, poll first one
                if(dq.size()!=0&&dq.peekFirst()==i-k){
                    dq.pollFirst();
                }
                // maintain the decreasing deque
                while(dq.size()!=0&&nums[dq.peekLast()]<=nums[i]){
                    dq.pollLast();
                }
                // Add the current into deque.
                dq.add(i);
                if(i>=k-1){
                    output[i-k+1]= nums[dq.peekFirst()];
                }
            }
            return output;
        }
    }
    static class TwoDParray{
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;
            int len;
            len = nums.length - k + 1;
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            int[] output = new int[len];
            left[0] = nums[0];
            right[nums.length - 1] = nums[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = Math.max(left[i - 1], nums[i]);
                }
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                if (i % k == 0) {
                    right[i] = nums[i];
                } else {
                    right[i] = Math.max(right[i + 1], nums[i]);
                }
            }
            for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
                output[i] = Math.max(left[j], right[i]);
            }
            return output;
        }

    }
}
