package com.leetcode.jolyon;

public class LC410SplitArrayLargestSum {
    /**
     * Use recursion to do brute force search
     */
    static class BruteForceSolution {
        private int ans;
        private int n, m;

        /**
         * At an index that is greater than 0, we can either add the current
         * element to the previous group or start a new group.
         * @param nums
         * @param i
         * @param cntSubarrays
         * @param curSum
         * @param curMax
         */
        private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
            if (i == n && cntSubarrays == m) {
                ans = Math.min(ans, curMax);
                return;
            }
            if (i == n) {
                return;
            }
            // If i ==0, then we can only start a new group.
            if (i > 0) {
                dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
            }
            if (cntSubarrays < m) {
                dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
            }
        }

        public int splitArray(int[] nums, int M) {
            ans = Integer.MAX_VALUE;
            n = nums.length;
            m = M;
            dfs(nums, 0, 0, 0, 0);
            return ans;
        }
    }

    class DPSolution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;

            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; ++i)
                for (int j = 0; j <= n; ++j)
                    dp[i][j] = Integer.MAX_VALUE;

            int[] prefixSum = new int[n + 1];
            prefixSum[0] = 0;
            for (int i = 1; i <= n; ++i){
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
                dp[1][i] = prefixSum[i];
            }
            for (int i = 2; i <= m; ++i)
                for (int j = i; j <= n; ++j)
                    for (int k = 0; k < j; ++k)
                        dp[i][j] = Math.min(dp[i][j], Math.max(prefixSum[j] - prefixSum[k], dp[i - 1][k]));

            return dp[m][n];
        }
    }

    /**
     * The key idea is to do trial and error, to validate the candidate answer.
     */
    static class BinarySearchSolution {
        public int splitArray(int[] nums, int m) {
            long right =0;
            for(int i=0;i<nums.length;i++){
                right+=nums[i];
            }
            long left = 0;
            while(left<=right){
                long mid = (left+right)/2;
                if(isValid(nums,mid,m)){
                    if(!isValid(nums,mid-1,m)){
                        return (int)mid;
                    }else{
                        right = mid;
                    }
                }else{
                    left = mid+1;
                }
            }
            return -1;

        }
        private boolean isValid(int[] nums, long target, int m){
            long curSum =0;
            int i=0;
            int splitNum =0;
            for(;i<nums.length&&m>0;i++){
                if(curSum+nums[i]<=target){
                    curSum += nums[i];
                }else{
                    splitNum++;
                    curSum = nums[i];
                    // If anyone of the element is greater than the target,
                    // return false
                    if(curSum>target){
                        return false;
                    }
                }
            }
            if(i==nums.length&&splitNum<m){
                return true;
            }else{
                return false;
            }
        }
    }
}
