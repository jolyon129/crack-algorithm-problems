package com.leetcode.jolyon;

public class LC278FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int lo=1;
            int hi=n;
            while(lo<hi){
                int mid = lo+ (hi-lo)/2;
                boolean t = isBadVersion(mid);
                if(!t){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
            return hi;
        }
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
