package jolyon;

public class LC493ReversePairs {
    public int reversePairs(int[] nums) {
        if(nums.length<2) return 0;
        return mergeSort(nums, 0, nums.length);
    }

    // not inlcuding index i
    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo + 1 == hi) {
            return 0;
        }
        int mid = (hi - lo) / 2 + lo;
        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid, hi);
        int i = lo;
        int j = mid;
        int t = mid;
        int[] cache = new int[hi - lo];
        int cacheIdx = 0;
        while (i < mid) {
            //Integer may overflow
//            while (j < hi && nums[i] > 2 * nums[j]) {
//                j++;
//            }
            while (j<hi&&nums[i]/2.0>nums[j]){
                j++;
            }
            count += j - mid;
            while (t < hi && nums[t] < nums[i]) {
                cache[cacheIdx] = nums[t];
                t++;
                cacheIdx++;
            }
            cache[cacheIdx] = nums[i];
            cacheIdx++;
            i++;
        }
        //The upper limit here should be t!!!
        for (int idx = lo; idx < t; idx++) {
            nums[idx] = cache[idx - lo];
        }

        return count;
    }

}
