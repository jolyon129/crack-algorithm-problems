package com.leetcode.jolyon.amazon;

public class LC74SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int M = matrix.length, N = matrix[0].length;
        int start = 0, end = M;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid][0] > target) end = mid;
            else start = mid + 1;
        }
        if(matrix[start][0]==target) return true;
        int row = start;
        start =0;
        end = N;
        while (start<end){
            int mid = (end - start) / 2 + start;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) start = mid;
            else end = mid;
        }
        return false;
    }
}
