package com.leetcode.jolyon;

import java.util.HashMap;
import java.util.Map;

public class IMCTradingOA {
    public int[] solution(int N, String artifacts, String searched) {
        if (artifacts.equals("") || searched.equals("")) {
            return new int[]{0, 0};
        }
        Integer[][] map = new Integer[N][N];

        String[] artifactInfoArr = artifacts.split(",");
        Map<Integer, Integer> artPiecesCount = new HashMap<>();
        Map<Integer, Integer> remainingArtPieces = new HashMap<>();
        String[] searchedArr = searched.split(" ");
        for (int i = 0; i < artifactInfoArr.length; i++) {
            String[] loc = artifactInfoArr[i].split(" ");
            int[] leftUpperPoint;
            int[] rightBottomPoint;
            if (loc.length == 1) {
                leftUpperPoint = locate(loc[0]);
                rightBottomPoint = leftUpperPoint;
            } else {
                leftUpperPoint = locate(loc[0]);
                rightBottomPoint = locate(loc[1]);
            }
            markMap(map, leftUpperPoint, rightBottomPoint, i);
            int num = (rightBottomPoint[0] - leftUpperPoint[0] + 1) * (rightBottomPoint[1] - leftUpperPoint[1] + 1);
            artPiecesCount.put(i, num);
            remainingArtPieces.put(i, num);
        }
        for (String info : searchedArr) {
            int[] point = locate(info);
            if (map[point[0]][point[1]] != null) {
                int id = map[point[0]][point[1]];
                remainingArtPieces.put(id, remainingArtPieces.get(id) - 1);
            }
        }
        int complete = 0, notFinished = 0;
        for (Integer key : remainingArtPieces.keySet()) {
            if (remainingArtPieces.get(key) == 0) {
                complete++;
            } else if (remainingArtPieces.get(key) < artPiecesCount.get(key)) {
                notFinished++;
            }
        }
        return new int[]{complete, notFinished};

    }

    void markMap(Integer[][] map, int[] p1, int[] p2, int id) {
        for (int i = p1[0]; i < p2[0] + 1; i++) {
            for (int j = p1[1]; j < p2[1] + 1; j++) {
                map[i][j] = id;
            }
        }
    }

    int[] locate(String locInfo) {
        StringBuilder sb = new StringBuilder();
        char letter = 'A';
        for (int i = 0; i < locInfo.length(); i++) {
            char c = locInfo.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                letter = c;
            }
        }
        return new int[]{Integer.parseInt(sb.toString()) - 1, letter - 'A'};
    }
}
