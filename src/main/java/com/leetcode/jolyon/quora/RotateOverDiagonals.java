package com.leetcode.jolyon.quora;

/*
 * 给一个matrix 和一串query，query有三种， rotate 90-degree clockwise， reflect along
 * main diagonal(upper left to bottom right), reflect along secondary diagonal(upper right to bottom left)
 * , 返回matrix。
 * */
public class RotateOverDiagonals {


    void rotate90(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                swap(matrix, i, j, i, N - 1 - j);
            }
        }

    }

    void rotateOverMainDiagonals(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    void rotateOverSecondDiagonals(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, N - 1 - j, N - 1 - i);
            }
        }
    }

    void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y2] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}
