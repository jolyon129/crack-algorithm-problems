package edu.nyu.jolyon;
import java.util.*;

public class LC220ContainsDuplicate3 {
    /**
     * Not optimal.
     * Use red-black tree.
     * T: O(nlog(min(n,k)))
     */
    static class Solution1{
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; ++i) {
                // Find the successor of current element
                Integer s = set.ceiling(nums[i]);
                if (s != null && s <= nums[i] + t) return true;

                // Find the predecessor of current element
                Integer g = set.floor(nums[i]);
                if (g != null && nums[i] <= g + t) return true;

                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }

    /**
     * Optimal Solution
     */
    static class Solution2{
        private long getBucketId(int num, int t){
            // Be careful!!
            // Since we are minus a min_value, change every int in
            return ((long)num - Integer.MIN_VALUE)/((long)t+1);
        }
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
            if(t<0) return false;
            Map<Long, Long> buckets = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                long bucketId = getBucketId(nums[i],t);
                if(buckets.containsKey(bucketId)) return true;
                if(buckets.containsKey(bucketId-1)&&(Math.abs(nums[i]-buckets.get(bucketId-1))<=t)) return true;
                if(buckets.containsKey(bucketId+1)&&(Math.abs(nums[i]-buckets.get(bucketId+1))<=t)) return true;
                buckets.put(bucketId,(long)nums[i]);
                if(i>=k){
                    buckets.remove(getBucketId(nums[i-k],t));
                }
            }
            return false;

        }
    }
}
