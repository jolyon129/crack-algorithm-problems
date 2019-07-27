package edu.nyu.jolyon;

import java.util.*;

public class LC200NumberOfIslands {
    static class Solution {

    }

    static class SolutionWithoutDFSBFS {
        public int numIslands(char[][] grid) {
            Set<Integer> equivalenceTable = new HashSet<>();
            int labelID = 2;
            int N = grid.length;
            if(N==0) return 0;
            int M = grid[0].length;
            int[][] labelGrid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == '1') {
                        int[] upper = new int[]{i-1, j};
                        int[] left = new int[]{i, j-1};
                        int leftLabel, upperLabel;
                        if (i == 0 && j == 0) {
                            ++labelID;
                            labelGrid[i][j] = labelID;
                            equivalenceTable.add(labelID);
                            continue;
                        }
                        if (i == 0) {
                            leftLabel = labelGrid[left[0]][left[1]];
                            if (leftLabel != 0) {
                                labelGrid[i][j] = leftLabel;
                            } else {
                                ++labelID;
                                labelGrid[i][j] = labelID;
                                equivalenceTable.add(labelID);
                            }
                            continue;
                        }
                        if (j == 0) {
                            upperLabel = labelGrid[upper[0]][upper[1]];
                            if (upperLabel != 0) {
                                labelGrid[i][j] = upperLabel;
                            } else {
                                ++labelID;
                                labelGrid[i][j] = labelID;
                                equivalenceTable.add(labelID);
                            }
                            continue;
                        }

                        upperLabel = labelGrid[upper[0]][upper[1]];
                        leftLabel = labelGrid[left[0]][left[1]];

                        if (leftLabel == 0 && upperLabel == 0) {
                            ++labelID;
                            labelGrid[i][j] = labelID;
                            equivalenceTable.add(labelID);
                        } else if (leftLabel != 0 && upperLabel != 0) {
                            labelGrid[i][j] = upperLabel;
                            if (leftLabel != upperLabel) {
                                int key = leftLabel;
                                equivalenceTable.remove(key);
                            } else {
                                labelGrid[i][j] = upperLabel;
                            }
                        } else {
                            labelGrid[i][j] = upperLabel != 0 ? (upperLabel) : leftLabel;
                        }

                    }
                }
            }
            return equivalenceTable.size();
        }
    }
}
