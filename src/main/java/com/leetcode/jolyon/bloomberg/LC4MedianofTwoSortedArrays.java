package com.leetcode.jolyon.bloomberg;

public class LC4MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        //if nums1 length is greater than switch them so that nums1 is smaller than nums2.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // nums1 is always the array with smaller length
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        // we are trying to find the proper insertion point.
        // for an array of length x, we have x+1 insertion point range from
        // [0, x]
        while (low <= high) {
            int partitionX = (low + high)/2;
            // Make sure the length of the combined left part is greater or
            // equal to the combined right part.
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and minFreq of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {// if even
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {// if odd
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};

        LC4MedianofTwoSortedArrays mm = new LC4MedianofTwoSortedArrays();
        mm.findMedianSortedArrays(x, y);
    }
}
