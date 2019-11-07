package com.leetcode.jolyon;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * LC215findKthLargest
 */
public class LC215findKthLargest {
    static class QuickSelectSol {
        public int findKthLargest(int[] nums, int k) {
            int k_smallest = nums.length - (k);
            return quickSelect(0, nums.length, nums, k_smallest);
        }

        public int quickSelect(int low, int high, int[] nums, int k_idx) {
            if (low >= high - 1) {
                return nums[low];
            }

            int part_idx;
            part_idx = partition(low, high, nums);
            if (part_idx == k_idx) {
                return nums[part_idx];
            } else if (part_idx < k_idx) {
                return quickSelect(part_idx + 1, high, nums, k_idx);
            } else {
                return quickSelect(low, part_idx, nums, k_idx);
            }
        }


        public int partition(int lo, int hi, int[] nums) {
            Random random = new Random();
            int part_idx = random.nextInt(hi - lo) + lo;
            int tmp = nums[hi - 1];
            nums[hi - 1] = nums[part_idx];
            nums[part_idx] = tmp;
            int i = lo;
            for (int j = lo; j < hi; j++) {
                if (nums[j] < nums[hi - 1]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i = i + 1;
                }
            }
            tmp = nums[hi - 1];
            nums[hi - 1] = nums[i];
            nums[i] = tmp;
            return i;
        }
    }

    static class PQSelect {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq =
                    new PriorityQueue<>((Integer w1, Integer w2) -> {
                        return w2 - w1;
                    });
            for (int n : nums) {
                pq.add(n);
            }
            int ans = -1;
            for (int i = 0; i < k; i++) {
                ans = pq.poll();
            }
            return ans;
        }

    }
}
