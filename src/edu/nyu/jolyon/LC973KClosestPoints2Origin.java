package edu.nyu.jolyon;

import java.util.*;

public class LC973KClosestPoints2Origin  {

    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        quicksort(points, K-1, 0, points.length);
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    private int calculateDistance(int x, int y) {
        return x * x + y * y;
    }

    private void quicksort(int[][] points, int K, int lo, int hi) {
        if (lo >= hi - 1) {
            return;
        }
        Random random = new Random();
        int idx = random.nextInt(hi - lo)+lo;
        swap(points, idx, hi - 1);
        int p = partition(points, lo, hi);
        if (p == K) {
            return;
        } else if (p < K) {
            quicksort(points, K, p + 1, hi);
        } else {
            quicksort(points, K, lo, p);
        }

    }

    private int partition(int[][] points, int lo, int hi) {
        int p = -1 + lo;
        for (int i = lo; i < hi; i++) {
            if (calculateDistance(points[i][0],
                    points[i][1]) < calculateDistance(points[hi - 1][0], points[hi - 1][1])) {
                p += 1;
                swap(points, i, p);
            }
        }
        p += 1;
        swap(points, p, hi - 1);
        return p;
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
