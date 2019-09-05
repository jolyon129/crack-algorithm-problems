package com.leetcode.jolyon;

import java.util.*;

public class LC36ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] column = new HashSet[9];
        Set<Integer>[] row = new HashSet[9];
        Set<Integer>[] matrix = new HashSet[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int t = (int)board[i][j];
                if(row[i]==null) row[i] = new HashSet<>();

                if(row[i].contains(t)) return false;
                else row[i].add(t);

                if(column[j]==null) column[j] = new HashSet<>();

                if(column[j].contains(t)) return false;
                else column[j].add(t);

                int nMatrix = i/3*3 + j/3;

                if(matrix[nMatrix]==null) matrix[nMatrix] = new HashSet<>();

                if(matrix[nMatrix].contains(t)) return false;
                else matrix[nMatrix].add(t);
            }
        }
        return true;
    }
}
