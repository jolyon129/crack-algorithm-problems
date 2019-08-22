package com.leetcode.jolyon;

public class LC33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int i = searchRotateIndex(nums);
        if (nums[i] == target) return i;
        int left = 0, right = nums.length - 1;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        if (nums[nums.length - 1] < target) {
            right = i - 1;
        } else if (nums[nums.length - 1] > target) {
            left = i;
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
        }
        return -1;
    }

    private int searchRotateIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // This solution is not O(logN)!!
    static public class OtherSolution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            boolean inLeft;
            if (nums[0] == target) return 0;
            else if (nums[nums.length - 1] == target) return nums.length - 1;
            else if (nums[0] > target) inLeft = false;
            else inLeft = true;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid] == target) return mid;
                if (nums[mid] > nums[0] && !inLeft) {
                    l++;
                } else if (nums[mid] < nums[0] && inLeft) {
                    r--;
                } else {
                    if (nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    // Same
    static public class MySolution {
        public int search(int[] nums, int target) {
            if(nums.length==0) return -1;
            if(nums.length==1) return nums[0]==target?0:-1;
            int l=0;
            int r = nums.length-1;

            boolean inLeft;
            int rotatedIdx = searchIdx(nums);
            if(target>nums[rotatedIdx]){
                return -1;
            }else if(target == nums[rotatedIdx]){
                return rotatedIdx;
            }

            if(target<nums[0]){
                l=rotatedIdx+1;
            }else if(target==nums[0]){
                return 0;
            }else{
                r=rotatedIdx;
            }
            while(l<=r){
                int mid =(l+r)/2;
                if(nums[mid]==target) return mid;
                else if(nums[mid]>target) r=mid-1;
                else l= mid +1;
            }
            return -1;


        }
        public int searchIdx(int[] nums){
            int l=0;
            int r= nums.length-1;
            // have to be l<r!! Cannot l==r!!
            while(l<r){
                int mid = (r-l)/2 +l;
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }
                if(nums[mid]>=nums[0]){
                    l=mid+1;
                }else{
                    r = mid;
                }
            }
            return nums.length-1;
        }
    }
}
