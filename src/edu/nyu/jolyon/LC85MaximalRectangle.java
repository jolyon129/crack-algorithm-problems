package edu.nyu.jolyon;

import java.util.Arrays;

public class LC85MaximalRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int max_area = 0;
        int[] height = new int[matrix[0].length];
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        Arrays.fill(right, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            // Initialize
            int cur_area, cur_left=0, cur_right= matrix[0].length;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;

                if (matrix[i][j] != '1') {
                    cur_left = j + 1;
                    //This is an Error-prone point
                    left[j] = 0;
                } else {
                    left[j] = Math.max(cur_left, left[j]);
                }
            }
            for (int j = matrix[0].length - 1; j >= 0; j--){
                if (matrix[i][j] != '1') {
                    cur_right = j;
                    //This is an Error-prone point
                    right[j] = matrix[0].length;
                } else {
                    right[j] = Math.min(cur_right, right[j]);
                }
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    cur_area = (right[j] - left[j]) * height[j];
                    max_area = Math.max(cur_area, max_area);
                }
            }
        }
        return max_area;

    }

}
