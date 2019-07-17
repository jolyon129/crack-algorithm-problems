package edu.nyu.jolyon;

public class LC303RangeSumQuery {
    static class NumArray{
        private int[] rangeSum;
        public NumArray(int[] nums) {
            rangeSum = new int[nums.length+1];
            int sum = 0;
            for (int i=0;i<nums.length;i++){
                sum += nums[i];
                rangeSum[i+1] =sum;
            }
        }

        public int sumRange(int i, int j) {
            return rangeSum[j+1]- rangeSum[i];

        }
    }
}
