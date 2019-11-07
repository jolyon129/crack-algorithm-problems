package com.leetcode.jolyon.quora;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortMatrixDiagonal {
    void sort(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int numOfDiagonals = M + N - 1;
        for (int i = 0; i < numOfDiagonals; i++) {
            List<Integer> tmp = new ArrayList<>();
            int r = i > (M - 1) ? i - (M - 1) : 0;
            int c = i > (M - 1) ? 0 : M - 1 - i;
            int r1 = r;
            int c1 = c;
            while (r < N && r >= 0 && c < M && c >= 0) {
                tmp.add(matrix[r][c]);
                r = r + 1;
                c = c + 1;
            }
            Collections.sort(tmp);
            int k = 0;
            while (r1 < N && r1 >= 0 && c1 < M && c1 >= 0) {
                matrix[r1][c1] = tmp.get(k);
                r1 = r1 + 1;
                c1 = c1 + 1;
                k++;
            }
        }
    }
}
