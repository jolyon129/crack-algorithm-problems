package edu.nyu.jolyon;

/**
 * LC1031maxSumTwoNoOverlap
 */
public class LC1031maxSumTwoNoOverlap {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        /**
         *  If M-length array occur after L,
         *  Msum: sum of the last M elements from the current idx
         *  Lsum: sum of the last L elements ending right before the M-length subarry
         *  Lmax: the maximum of the sum of the last L elements before the M-length subarray
         */
        int res = 0, Lsum = 0, Lmax = 0, Msum = 0, Mmax = 0;
        for (int i = 0; i < A.length; ++i) {
            Msum += A[i];
            if (i - M >= 0)
                Msum -= A[i - M];
            if (i - M >= 0)
                Lsum += A[i - M];
            if (i - M - L >= 0)
                Lsum -= A[i - L - M];
            Lmax = Math.max(Lmax, Lsum);
            res = Math.max(res, Lmax + Msum);
        }
        // If L-length array occur after M
        Lsum = Lmax = Msum = Mmax = 0;
        for (int i = 0; i < A.length; ++i) {
            Lsum += A[i];
            if (i - L >= 0)
                Lsum -= A[i - L];
            if (i - L >= 0)
                Msum += A[i - L];
            if (i - M - L >= 0)
                Msum -= A[i - L - M];
            Mmax = Math.max(Mmax, Msum);
            res = Math.max(res, Mmax + Lsum);
        }
        return res;
    }

}